package com.liaoxx.spring_hello.repository.plug;

import com.liaoxx.spring_hello.entity.plug.Plug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlugRepository extends JpaRepository<Plug, Integer>, JpaSpecificationExecutor<Plug> {

    Plug findFirstByKeyOrderByIdDesc(String key );
}