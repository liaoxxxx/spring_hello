package com.liaoxx.spring_hello.repository.goods;

import com.liaoxx.spring_hello.entity.goods.GoodsSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GoodsSpecRepository extends JpaRepository<GoodsSpec, Integer> , JpaSpecificationExecutor<GoodsSpec> {
}