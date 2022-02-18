package com.liaoxx.spring_hello.repository.goods;

import com.liaoxx.spring_hello.entity.goods.GoodsOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;

public interface GoodsOptionRepository extends JpaRepository<GoodsOption, Integer>, JpaSpecificationExecutor<GoodsOption> {
}