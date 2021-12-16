package com.liaoxx.spring_hello.repository.goods;

import com.liaoxx.spring_hello.entity.goods.GoodsClassify;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

//继承JpaRepository 来完成对数据库的操作
@Repository
public interface GoodsClassifyRepository extends JpaRepository<GoodsClassify,Integer> , JpaSpecificationExecutor<GoodsClassify> {
    //GoodsCategory findByCateName(String cateName);

     Page<GoodsClassify> findAll(Pageable pageable);;

}
