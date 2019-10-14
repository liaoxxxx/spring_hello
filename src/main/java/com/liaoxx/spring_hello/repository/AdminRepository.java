package com.liaoxx.spring_hello.repository;

import com.liaoxx.spring_hello.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
//继承JpaRepository 来完成对数据库的操作
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findByUsername(String username);
}
