package com.liaoxx.spring_hello.repository.common;

import com.liaoxx.spring_hello.entity.common.CommonBanner;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CommonBannerRepository extends JpaRepository<CommonBanner, Integer>, JpaSpecificationExecutor<CommonBanner> {

}