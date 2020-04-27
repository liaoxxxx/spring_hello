package com.liaoxx.spring_hello.service;
import com.liaoxx.spring_hello.dto.admin.GoodsCategoryDto;
import com.liaoxx.spring_hello.entity.GoodsCategory;
import com.liaoxx.spring_hello.repository.GoodsCategoryRepository;
import com.liaoxx.spring_hello.util.JsonResponse;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsCategoryService {

    @Autowired
    GoodsCategoryRepository goodsCategoryRepository;


    public boolean add(GoodsCategoryDto goodsCategoryDto){
        long timeTamp=SqlTimeTool.getMicroTimeTamp();
        System.out.println(timeTamp);
        GoodsCategory goodsCategory=new GoodsCategory();
        BeanUtils.copyProperties(goodsCategoryDto,goodsCategory);
        goodsCategory.setCreatedAt(timeTamp);
        goodsCategory.setUpdatedAt(timeTamp);
        goodsCategoryRepository.save(goodsCategory);
        return true;
    }



    public List getList(int page,int pageSize,String cateName){
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
        //所有的 商品分类
        return  goodsCategoryRepository.findAll();
    }




    public GoodsCategory getById(int id){
        return goodsCategoryRepository.getOne(id);
    }


    public GoodsCategory update(GoodsCategory goodsCategory){
        return goodsCategoryRepository.save(goodsCategory);
    }
}
