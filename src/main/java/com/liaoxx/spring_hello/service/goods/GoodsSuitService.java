package com.liaoxx.spring_hello.service.goods;


import com.liaoxx.spring_hello.entity.goods.GoodsSuit;
import com.liaoxx.spring_hello.repository.goods.GoodsSuitRepository;
import com.liaoxx.spring_hello.repository.goods.GoodsSuitRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsSuitService {

    @Resource
    GoodsSuitRepository suitRepository;

    public List<GoodsSuit> list() {
        List<GoodsSuit> list = suitRepository.findAll();
        return list;
    }

    public List<GoodsSuit> list(Specification<GoodsSuit> spec , Pageable pageable) {
        Page<GoodsSuit> goodsPages = suitRepository.findAll(spec,pageable);
        return goodsPages.getContent();
    }


    public List<GoodsSuit> list(Specification<GoodsSuit> spec ) {
        List<GoodsSuit> goodsList = suitRepository.findAll(spec);
        return goodsList;
    }



}
