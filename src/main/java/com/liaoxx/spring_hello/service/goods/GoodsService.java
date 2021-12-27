package com.liaoxx.spring_hello.service.goods;

import com.alibaba.fastjson.JSON;
import com.liaoxx.spring_hello.constants.MainState;
import com.liaoxx.spring_hello.export.admin.GoodsDto;
import com.liaoxx.spring_hello.export.api.goods.GoodsDetailExport;
import com.liaoxx.spring_hello.export.api.goods.GoodsListExport;
import com.liaoxx.spring_hello.entity.goods.Goods;
import com.liaoxx.spring_hello.entity.goods.GoodsOption;
import com.liaoxx.spring_hello.entity.goods.GoodsSpec;
import com.liaoxx.spring_hello.entity.goods.GoodsSpecItem;
import com.liaoxx.spring_hello.repository.goods.GoodsOptionRepository;
import com.liaoxx.spring_hello.repository.goods.GoodsRepository;
import com.liaoxx.spring_hello.repository.goods.GoodsSpecItemRepository;
import com.liaoxx.spring_hello.repository.goods.GoodsSpecRepository;
import com.liaoxx.spring_hello.service.exception.ServiceException;
import com.liaoxx.spring_hello.util.Pagination;
import com.liaoxx.spring_hello.util.SpecUtil;
import com.liaoxx.spring_hello.util.SqlTimeTool;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class GoodsService {

    @Resource
    GoodsRepository goodsRepository;

    @Resource
    GoodsOptionRepository optionRepository;

    @Resource
    GoodsSpecItemRepository specItemRepository;

    @Resource
    GoodsSpecRepository specRepository;


    public boolean add(GoodsDto goodsDto) {
        //System.out.println(goodsDto.getImages()[0]);
        long timeTamp = SqlTimeTool.getMicroTimeTamp();
        Goods goods = new Goods();
        System.out.println(goodsDto.toString());
        BeanUtils.copyProperties(goodsDto, goods);

        goods.setThumb(this.encodeImages(goodsDto.getThumb()));
        System.out.println("================================");
        System.out.println(goods.getThumb());
        System.out.println("================================");


        goodsRepository.save(goods);
        return true;
    }


    public GoodsListExport list(Map<String, String[]> paramMap, int page, int pagesize) {
        GoodsListExport goodsListDto = new GoodsListExport();
        goodsListDto.page = page;
        goodsListDto.pagesize = pagesize;
        Specification<Goods> specification = SpecUtil.fromRequestParamMap(paramMap, Goods.class);
        Pageable pageable = Pagination.pageAble(page, pagesize);
        Page<Goods> goodsPages = goodsRepository.findAll(specification, pageable);

        goodsListDto.list = goodsPages.getContent();
        goodsListDto.count = goodsPages.getTotalElements();
        return goodsListDto;
    }

    public List<Goods> list() {

        List<Goods> list = goodsRepository.findAll();
        return list;
    }

    public Page<Goods> listPage(Specification<Goods> spec, Pageable pageable) {
        Page<Goods> goodsPages = goodsRepository.findAll(spec, pageable);
        return goodsPages;
    }


    public List<Goods> list(Specification<Goods> spec) {
        List<Goods> goodsList = goodsRepository.findAll(spec);
        return goodsList;
    }

    /**
     * @param id  商品的id
     *
     */
    public GoodsDetailExport detail(int id) throws ServiceException {
        ArrayList<Integer> specIds =new ArrayList<>();
    /*    var (
                imgs     []string
        spec_ids []int64
        sku      []*model.GoodsOption
	)
        list, err := GoodsGet(map[string]interface{}{"id": c.FormValue("id")})
        if list == nil || err != nil {
            return c.JSON(open.ErrJson("商品不存在", open.ERROR_PARAMS))
        }
        //处理轮播图
        imgs = append(imgs, list.Thumb)
        if string(list.Thumbs) != "" {
            var (
                    img []string
		)
            err = json.Unmarshal([]byte(string(list.Thumbs)), &img)
            if err != nil {
                return c.JSON(open.SuccJson(c, _Rs))
            }
            //过滤mp4
            for _, v := range img {
                if path.Ext(v) == ".mp4" {
                    continue
                }
                imgs = append(imgs, v)
            }
        }
        list.Images = imgs

        //分类处理
        ids := []int64{list.Cate, list.Pcate, list.Tcate}
        classify, err := rpc.Goods.RPC_Get_GoodsClassifyGetIn(ids, map[string]interface{}{})
        if err != nil {
            return c.JSON(open.SuccJson(c, _Rs))
        }
        for _, v := range classify {
            if v.Pid == 0 {
                list.PcateName = v.Name
            }
            if v.Pid == list.Pcate {
                list.CateName = v.Name
            }
            if v.Pid == list.Cate {
                list.TcateName = v.Name
            }
        }
        // 获取分类信息
        list.Content = html.UnescapeString(list.Content)
        option, err := GoodsOption(map[string]interface{}{"state": model.StateOK, "goods_id": list.Id})
        if err != nil {
            return c.JSON(open.SuccJson(c, _Rs))
        }
        //获取规格
        spec_item, err := GoodsSpecItem(map[string]interface{}{"goods_id": list.Id})
        if err != nil {
            return c.JSON(open.SuccJson(c, _Rs))
        }
        for _, t := range spec_item {
            spec_ids = append(spec_ids, int64(t.Specid))
        }
        // 获取子类
        spec, err := GoodsSpecIn("id", map[string]interface{}{}, spec_ids)
        if err != nil {
            return c.JSON(open.SuccJson(c, _Rs))
        }
        costprice, productprice, marketprice, profit := rpc.User.RPC_Get_UserPrice(c, list.Costprice, list.Productprice, list.Marketprice)

        sell, err := rpc.User.RPC_Get_MerchantGoodsIn([]int64{list.Id}, util.Int64s(c.Get("uid")))
        if len(sell) != 0 {
            list.Is_sell = true
        }
        list.Created_at_str = util.Time2Str(list.Created_at)
        //对价格进行测算
        list.Costprice = costprice
        list.Productprice = productprice
        list.Marketprice = marketprice
        list.Profit = profit
        GoodsAddHistory(util.Int64s(c.Get("uid")), list.Id)
        for _, v := range option {
            t := &model.GoodsOption{}
            t = v
            costprice, productprice, marketprice, profit := rpc.User.RPC_Get_UserPrice(c, v.Costprice, v.Productprice, v.Marketprice)
            t.Costprice = costprice
            t.Productprice = productprice
            t.Marketprice = marketprice
            t.Profit = profit
            sku = append(sku, t)
        }
        _Rs = map[string]interface{}{
            "list":      list,
                    "option":    sku,
                    "spec_item": spec_item,
                    "spec":      spec,
        }
*/

        GoodsDetailExport detailDto = new GoodsDetailExport();
        Optional<Goods> goods = goodsRepository.findById(id);
        goods.get().initImages();
        if (goods.isEmpty()) {
            throw new ServiceException("商品不存在");
        }
        detailDto.list = goods;
        //查找 该商品的说有有效的sku
        HashMap<String, Object> optionSearch = new HashMap();
        optionSearch.put("state|eq", MainState.StateOK);
        optionSearch.put("goods_id|eq", id);
        System.out.println(optionSearch);
        Specification<GoodsOption>  optionSpec= SpecUtil.fromMap(optionSearch, GoodsOption.class);
        List<GoodsOption> optionList = optionRepository.findAll(optionSpec);
        detailDto.option = optionList;

        //查找 该商品的所有有效的spec规格 值
        HashMap<String, Object> specItemSearch = new HashMap();
        specItemSearch.put("goods_id", id);
        System.out.println(optionSearch);
        Specification<GoodsSpecItem>  specItemSpec= SpecUtil.fromMap(specItemSearch, GoodsSpecItem.class);
        List<GoodsSpecItem> specItemList = specItemRepository.findAll(specItemSpec);
        detailDto.spec_item = specItemList;


        //查找 该商品的所有spec规格
        for (GoodsSpecItem specItem: specItemList) {
            specIds.add(specItem.getSpecid());
        }
        List<GoodsSpec> specList = specRepository.findAllById(specIds);
        detailDto.spec = specList;
        return detailDto;
    }


    public String encodeImages(String[] imagesArr) {
        return JSON.toJSONString(imagesArr);
    }


    public Goods findById(int id) {
        return goodsRepository.getOne(id);
    }


}
