package com.liaoxx.spring_hello.repository;

import com.liaoxx.spring_hello.entity.GoodsCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

//继承JpaRepository 来完成对数据库的操作
@Repository
public interface GoodsCategoryRepository extends JpaRepository<GoodsCategory,Integer> , JpaSpecificationExecutor<GoodsCategory> {
    //GoodsCategory findByCateName(String cateName);

}
