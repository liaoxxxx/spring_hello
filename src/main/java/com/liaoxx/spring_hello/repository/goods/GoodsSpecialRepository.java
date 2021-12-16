package com.liaoxx.spring_hello.repository.goods;

import com.liaoxx.spring_hello.entity.goods.GoodsSpecial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GoodsSpecialRepository extends JpaRepository<GoodsSpecial, Integer> , JpaSpecificationExecutor<GoodsSpecial> {
}