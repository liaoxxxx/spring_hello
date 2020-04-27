package com.liaoxx.spring_hello.service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.graphbuilder.math.func.EFunction;
import com.liaoxx.spring_hello.dto.admin.GoodsDto;
import com.liaoxx.spring_hello.entity.Goods;
import com.liaoxx.spring_hello.repository.GoodsCategoryRepository;
import com.liaoxx.spring_hello.repository.GoodsRepository;
import com.liaoxx.spring_hello.util.SqlTimeTool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsRepository goodsRepository;


    public boolean add(GoodsDto goodsDto){
        //System.out.println(goodsDto.getImages()[0]);
        long timeTamp=SqlTimeTool.getMicroTimeTamp();
        Goods goods=new Goods();
        System.out.println(goodsDto.toString());
        BeanUtils.copyProperties(goodsDto,goods);

        goods.setThumb(this.encodeImages(goodsDto.getThumb()));
        goods.setImages(this.encodeImages(goodsDto.getImages()));
        System.out.println("================================");
        System.out.println(goods.getThumb());
        System.out.println("================================");
        goods.setStatus((byte) 1);
        goods.setIsDelete((byte) 0);
        goods.setCreatedAt(timeTamp);
        goods.setUpdatedAt(timeTamp);
        goodsRepository.save(goods);
        return true;
    }



    public List<Goods> list(){

        List<Goods> list= goodsRepository.findAll();
        return list;
    }


    public String encodeImages(String[] imagesArr){
        return JSON.toJSONString(imagesArr);
    }



    public Goods findById(int id){
        return goodsRepository.getOne(id);
    }

   /* public List getList(int page,int pageSize,String cateName){
        //条件
        Specification<GoodsCategory> spec = new Specification<GoodsCategory>() {
            @Override
            public Predicate toPredicate(Root<GoodsCategory> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("cate_name").as(String.class),cateName+"%");
            }


        };
        //排序
        Sort sort = new Sort(Sort.Direction.DESC,"id");

        List<GoodsCategory> list=goodsCategoryRepository.findAll(sort);
        for (GoodsCategory i:list) {
           i.setCreatedAtStr(SqlTimeTool.transMicroTime2Date(i.getCreatedAt()));
            i.setUpdateAtStr(SqlTimeTool.transMicroTime2Date(i.getUpdatedAt()));
        }
        return list;


    }


    public List<GoodsCategory> findAll(){
        return goodsCategoryRepository.findAll();
    }






    public GoodsCategory update(GoodsCategory goodsCategory){
        return goodsCategoryRepository.save(goodsCategory);
    }*/



   public List<Goods> getRecommendList(int limit){
       return goodsRepository.OrderByRecommendSortDesc();
   }
}
