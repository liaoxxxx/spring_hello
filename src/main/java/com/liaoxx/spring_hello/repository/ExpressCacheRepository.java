package com.liaoxx.spring_hello.repository;

import com.liaoxx.spring_hello.entity.ExpressCache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//继承JpaRepository 来完成对数据库的操作
public interface ExpressCacheRepository extends JpaRepository<ExpressCache,Integer> {
    ExpressCache  getByExpressProviderCodeAndExpressNo(String Code,String expressNo);


}
