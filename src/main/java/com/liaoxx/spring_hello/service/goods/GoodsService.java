package com.liaoxx.spring_hello.service.goods;

import com.alibaba.fastjson.JSON;
import com.liaoxx.spring_hello.constants.MainState;
import com.liaoxx.spring_hello.dto.admin.GoodsDto;
import com.liaoxx.spring_hello.dto.api.goods.GoodsListDto;
import com.liaoxx.spring_hello.entity.goods.Goods;
import com.liaoxx.spring_hello.param.api.goods.GoodsListParam;
import com.liaoxx.spring_hello.repository.goods.GoodsRepository;
import com.liaoxx.spring_hello.util.Pagination;
import com.liaoxx.spring_hello.util.SpecUtil;
import com.liaoxx.spring_hello.util.SqlTimeTool;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
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


        goodsRepository.save(goods);
        return true;
    }


    public GoodsListDto list(GoodsListParam goodsListParam) {
        GoodsListDto goodsListDto = new GoodsListDto();
        goodsListDto.page = goodsListParam.page;
        goodsListDto.pagesize = goodsListParam.pagesize;
        HashMap<String ,Object> map=new HashMap<>();
        map.put("state", MainState.StateOK);
        map.put("isHot",goodsListParam.isHot);
        map.put("title|like",goodsListParam.title);
        Specification<Goods> specification=  SpecUtil.fromMap(map,Goods.class);
        List<Goods> goodsList= goodsRepository.findAll(specification);
       // Pageable goodsPages = this.listPage(, );
        goodsListDto.list=goodsList;
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


    public String encodeImages(String[] imagesArr) {
        return JSON.toJSONString(imagesArr);
    }


    public Goods findById(int id) {
        return goodsRepository.getOne(id);
    }


}
