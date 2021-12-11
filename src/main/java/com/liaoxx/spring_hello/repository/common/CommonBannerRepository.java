package com.liaoxx.spring_hello.repository.common;

import com.liaoxx.spring_hello.entity.common.CommonBanner;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CommonBannerRepository extends JpaRepository<CommonBanner, Integer>, JpaSpecificationExecutor<CommonBanner> {
    @Override
    public List<CommonBanner> findAll();
}