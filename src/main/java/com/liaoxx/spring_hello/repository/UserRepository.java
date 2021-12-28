package com.liaoxx.spring_hello.repository;

import com.liaoxx.spring_hello.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

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
