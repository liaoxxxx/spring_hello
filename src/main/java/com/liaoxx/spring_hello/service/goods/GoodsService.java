package com.liaoxx.spring_hello.service.goods;

import com.alibaba.fastjson.JSON;
import com.liaoxx.spring_hello.constants.MainState;
import com.liaoxx.spring_hello.entity.goods.*;
import com.liaoxx.spring_hello.export.admin.GoodsDto;
import com.liaoxx.spring_hello.export.api.goods.GoodsDetailExport;
import com.liaoxx.spring_hello.export.api.goods.GoodsListExport;
import com.liaoxx.spring_hello.repository.goods.GoodsOptionRepository;
import com.liaoxx.spring_hello.repository.goods.GoodsRepository;
import com.liaoxx.spring_hello.repository.goods.GoodsSpecItemRepository;
import com.liaoxx.spring_hello.repository.goods.GoodsSpecRepository;
import com.liaoxx.spring_hello.exception.ServiceException;
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
        Specification<GoodsOption>  optionSpec= SpecUtil.fromMap(optionSearch, GoodsOption.class);
        List<GoodsOption> optionList = optionRepository.findAll(optionSpec);
        //转成 DTO
        ArrayList<GoodsOptionDto> optionDtoList =new ArrayList<>();
        optionList.forEach((e) -> {
            optionDtoList.add(new GoodsOptionDto().fromEntity(e));
        });
        detailDto.option = optionDtoList;

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
