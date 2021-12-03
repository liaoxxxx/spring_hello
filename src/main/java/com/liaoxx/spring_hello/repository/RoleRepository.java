package com.liaoxx.spring_hello.repository;

import com.liaoxx.spring_hello.entity.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository 来完成对数据库的操作
public interface RoleRepository extends JpaRepository<AdminRole,Integer> {

}
