package com.liaoxx.spring_hello.repository.goods;

import com.liaoxx.spring_hello.entity.goods.GoodsSpecItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GoodsSpecItemRepository extends JpaRepository<GoodsSpecItem, Integer> , JpaSpecificationExecutor<GoodsSpecItem> {
}