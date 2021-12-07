package com.liaoxx.spring_hello.repository;

import com.liaoxx.spring_hello.entity.system.System;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SystemRepository extends JpaRepository<System, Integer>, JpaSpecificationExecutor<System> {
    System findFirstByKey(String key );
}