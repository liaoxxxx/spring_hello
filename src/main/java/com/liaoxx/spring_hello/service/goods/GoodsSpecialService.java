package com.liaoxx.spring_hello.service.goods;


import com.liaoxx.spring_hello.entity.goods.GoodsOption;
import com.liaoxx.spring_hello.entity.goods.GoodsSpecial;
import com.liaoxx.spring_hello.repository.goods.GoodsSpecialRepository;
import com.liaoxx.spring_hello.rpc.GoodsRpc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GoodsSpecialService {

    @Resource
    GoodsSpecialRepository specialRepository;

    public List<GoodsSpecial> list() {
        List<GoodsSpecial> list = specialRepository.findAll();
        return list;
    }

    public List<GoodsSpecial> list(Specification<GoodsSpecial> spec , Pageable pageable) {
        Page<GoodsSpecial> goodsPages = specialRepository.findAll(spec,pageable);
        return goodsPages.getContent();
    }


    public List<GoodsSpecial> list(Specification<GoodsSpecial> spec ) {
        List<GoodsSpecial> goodsList = specialRepository.findAll(spec);
        return goodsList;
    }


/*
    public List<GoodsOption>  getGoodsOptionByIds(List<Integer> ids, List<Integer>  option, List<Integer>  goods, Map<String,Object> order , Map<String,Object>  specialItem ){
        List<GoodsOption> _Rs = new ArrayList<>();
        if( ids.isEmpty() || option.isEmpty()||goods.isEmpty() || specialItem.isEmpty()) {
            return _Rs;
        }
        List<GoodsSpecial> special= specialRepository.findAllById(ids);
        if (special.isEmpty()) {
            return _Rs;
        }
        item= GoodsRpc.Get_GoodsOptionIn(goods, option, map[string]interface{}{})
        items, err := open.Svr.Dao.GoodsSpecialGoodsOptionGetAllIn(ids, goods, option, order);
        if len(item) == 0 || err != nil || len(*items) == 0 {
            return _Rs, nil
        }
        //品牌
        var (
                brand_ids []int64
	)
        for _, vv := range item {
            brand_ids = append(brand_ids, vv.Brand_id)
        }
        brand, err := rpc.Goods.RPC_Get_BrandIn(brand_ids, map[string]interface{}{})
        for _, v := range special_item {
            t := &model.GoodsOption{}
            for _, vv := range item {
                if vv.Goods_id == util.Int64s(v["goods_id"]) && vv.Id == util.Int64s(v["option_id"]) {
                    t.Thumb = vv.Thumb
                    t.Attr = vv.Attr
                    t.Brand_id = vv.Brand_id
                    t.Stock = vv.Stock
                    t.Title = vv.Title
                    t.State = vv.State
                    t.Productsn = vv.Productsn
                    t.Goodssn = vv.Goodssn
                    for _, vvvv := range brand {
                        if vv.Brand_id == vvvv.Id {
                            t.Brand_name = vvvv.Name
                        }
                    }
                }
            }
            //获取在哪个专场
            for _, vvv := range *special {
                if util.Int64s(v["special_id"]) == vvv.Id {
                    t.Source_name = vvv.Name
                }
            }
            //如果专场有数据则从专场这边把商品拉过去
            for _, vvvv := range *items {
                if vvvv.Special_id == util.Int64s(v["special_id"]) && vvvv.Goods_id == util.Int64s(v["goods_id"]) && vvvv.Option_id == util.Int64s(v["option_id"]) {
                    t.Costprice = vvvv.Costprice
                    t.Productprice = vvvv.Productprice
                }
            }
            t.Source_id = fmt.Sprintf("%v", v["special_id"])
            t.Goods_id = util.Int64s(v["goods_id"])
            t.Option_id = util.Int64s(v["option_id"])
            _Rs = append(_Rs, t)
        }
        r = _Rs
        return
    }

*/

}
