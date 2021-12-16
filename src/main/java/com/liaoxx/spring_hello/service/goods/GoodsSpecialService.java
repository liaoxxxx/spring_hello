package com.liaoxx.spring_hello.service.goods;


import com.liaoxx.spring_hello.entity.goods.GoodsSpecial;
import com.liaoxx.spring_hello.repository.goods.GoodsSpecialRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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



}
