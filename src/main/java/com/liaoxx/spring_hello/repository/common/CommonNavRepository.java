package com.liaoxx.spring_hello.repository.common;

import com.liaoxx.spring_hello.entity.common.CommonNav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommonNavRepository extends JpaRepository<CommonNav, Integer>, JpaSpecificationExecutor<CommonNav> {
}