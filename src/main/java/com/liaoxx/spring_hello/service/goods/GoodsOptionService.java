package com.liaoxx.spring_hello.service.goods;


import com.liaoxx.spring_hello.entity.goods.Goods;
import com.liaoxx.spring_hello.entity.goods.GoodsBrand;
import com.liaoxx.spring_hello.entity.goods.GoodsOption;
import com.liaoxx.spring_hello.entity.goods.GoodsOptionDto;
import com.liaoxx.spring_hello.repository.goods.GoodsOptionRepository;
import com.liaoxx.spring_hello.repository.goods.GoodsRepository;
import com.liaoxx.spring_hello.rpc.GoodsRpc;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class GoodsOptionService {

    @Resource
    GoodsOptionRepository optionRepository;

    @Resource
    GoodsRepository goodsRepository;

    @Resource
    GoodsRpc goodsRpc;

    public List<GoodsOptionDto> GoodsOptionIn(List<Integer> goodsIds, List<Integer> optionIds, Map<String, Object> where) {
        List<GoodsOptionDto> goodsOptionListRes = new ArrayList<>();
        List<Long> brandIds = new ArrayList<>();
        if (goodsIds.size() == 0 || optionIds.size() == 0) {
            return goodsOptionListRes;
        }
        //获取单个商品
        List<Goods> goodsList = goodsRepository.findAllById(goodsIds);
        if (goodsList.size() == 0) {
            return goodsOptionListRes;
        }
        //获取单个商品sku
        List<GoodsOption> optionList = optionRepository.findAllById(optionIds);
        if (optionList.size() == 0) {
            return goodsOptionListRes;
        }
        //获取品牌
        for (Goods goods : goodsList) {
            brandIds.add(goods.getBrand_id());
        }

        List<GoodsBrand> brandList = goodsRpc.Get_BrandIn(brandIds, null);
        for (GoodsOption goodsOption : optionList) {
            GoodsOptionDto optionDto = new GoodsOptionDto();
            optionDto = optionDto.fromEntity(goodsOption);

            optionDto.setAttr(goodsOption.getTitle());
            for (Goods goods : goodsList) {
                if (goodsOption.getGoods_id() == goods.getId()) {
                    optionDto.setTitle(goods.getTitle());
                    if (optionDto.getThumb().equals("")) {
                        optionDto.setThumb(goods.getThumb());
                    }
                    optionDto.setBrand_id(goods.getBrand_id());
                    for (GoodsBrand brand : brandList) {
                        if (brand.getId() == goods.getBrand_id()) {
                            optionDto.setBrand_name(brand.getName());
                        }
                    }
                }
            }
            optionDto.setOption_id(optionDto.getId());
            optionDto.setStock(goodsOption.getStock());
            optionDto.setSource_id(goodsOption.getSource_id());
            optionDto.setSource_sku_id(goodsOption.getSource_id());
            optionDto.setSource_name(goodsOption.getSource_name());
            goodsOptionListRes.add(optionDto);
        }

        return goodsOptionListRes;
    }

}
