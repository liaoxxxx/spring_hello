package com.liaoxx.spring_hello.repository.common;

import com.liaoxx.spring_hello.entity.common.CommonAd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommonAdRepository extends JpaRepository<CommonAd, Integer> , JpaSpecificationExecutor<CommonAd> {
}