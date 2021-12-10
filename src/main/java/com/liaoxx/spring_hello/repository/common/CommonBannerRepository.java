package com.liaoxx.spring_hello.repository.common;

import com.liaoxx.spring_hello.entity.common.CommonBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommonBannerRepository extends JpaRepository<CommonBanner, Integer>, JpaSpecificationExecutor<CommonBanner> {
}