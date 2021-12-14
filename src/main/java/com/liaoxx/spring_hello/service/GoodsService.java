package com.liaoxx.spring_hello.service;

import com.alibaba.fastjson.JSON;
import com.liaoxx.spring_hello.dto.admin.GoodsDto;
import com.liaoxx.spring_hello.entity.Goods;
import com.liaoxx.spring_hello.param.api.goods.GoodsListParam;
import com.liaoxx.spring_hello.repository.GoodsRepository;
import com.liaoxx.spring_hello.util.SqlTimeTool;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsService {

    @Resource
    GoodsRepository goodsRepository;


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
        goods.setIsDelete((byte) 0);
        goods.setCreatedAt(timeTamp);
        goods.setUpdatedAt(timeTamp);
        goodsRepository.save(goods);
        return true;
    }


    public List<Goods> list(GoodsListParam goodsListParam) {

        List<Goods> list = goodsRepository.findAll();
        return list;
    }

    public List<Goods> list() {

        List<Goods> list = goodsRepository.findAll();
        return list;
    }

    public List<Goods> list(Specification<Goods> spec , Pageable pageable) {
        Page<Goods> goodsPages = goodsRepository.findAll(spec,pageable);
        return goodsPages.getContent();
    }


    public List<Goods> list(Specification<Goods> spec ) {
        List<Goods> goodsList = goodsRepository.findAll(spec);
        return goodsList;
    }


    public String encodeImages(String[] imagesArr) {
        return JSON.toJSONString(imagesArr);
    }


    public Goods findById(int id) {
        return goodsRepository.getOne(id);
    }



    public List<Goods> getRecommendList(int limit) {
        return goodsRepository.OrderByRecommendSortDesc();
    }
}
