package com.liaoxx.spring_hello.repository;

import com.liaoxx.spring_hello.entity.User;
import jdk.jfr.Enabled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

//继承JpaRepository 来完成对数据库的操作

public interface UserRepository extends JpaRepository<User,Integer> , JpaSpecificationExecutor<User> {
    //GoodsCategory findByCateName(String cateName);


    /**
     * 通过手机号查找用户
     * @param phone 手机号码
     */
    User findFirstByPhoneOrderByIdDesc(String phone);



    User findByUsername(String username);
}
