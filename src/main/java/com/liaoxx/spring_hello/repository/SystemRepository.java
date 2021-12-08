package com.liaoxx.spring_hello.repository;

import com.liaoxx.spring_hello.entity.system.SystemConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SystemRepository extends JpaRepository<SystemConfig, Integer>, JpaSpecificationExecutor<SystemConfig> {
    SystemConfig findFirstByKey(String key );
}