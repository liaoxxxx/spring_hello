package com.liaoxx.spring_hello.repository.goods;

import com.liaoxx.spring_hello.entity.goods.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

//继承JpaRepository 来完成对数据库的操作
@Repository
public interface GoodsRepository extends JpaRepository<Goods,Integer> , JpaSpecificationExecutor<Goods> {
    //GoodsCategory findByCateName(String cateName);



}
