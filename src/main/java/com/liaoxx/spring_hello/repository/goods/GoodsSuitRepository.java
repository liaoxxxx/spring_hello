package com.liaoxx.spring_hello.repository.goods;

import com.liaoxx.spring_hello.entity.goods.GoodsSuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GoodsSuitRepository extends JpaRepository<GoodsSuit, Integer> , JpaSpecificationExecutor<GoodsSuit> {
}