package com.liaoxx.spring_hello.repository;


import com.liaoxx.spring_hello.entity.Dto;
import org.springframework.data.jpa.repository.JpaRepository;


//继承JpaRepository 来完成对数据库的操作
public interface DtoRepository extends JpaRepository<Dto,Integer> {
}
