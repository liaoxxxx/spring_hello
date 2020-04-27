package com.liaoxx.spring_hello.repository;

import com.liaoxx.spring_hello.entity.Goods;
import com.liaoxx.spring_hello.entity.GoodsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

//继承JpaRepository 来完成对数据库的操作
@Repository
public interface GoodsRepository extends JpaRepository<Goods,Integer> , JpaSpecificationExecutor<Goods> {
    //GoodsCategory findByCateName(String cateName);

    List<Goods> OrderByRecommendSortDesc();

}
