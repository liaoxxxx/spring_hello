package com.liaoxx.spring_hello.repository;

import com.liaoxx.spring_hello.entity.Goods;
import com.liaoxx.spring_hello.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

//继承JpaRepository 来完成对数据库的操作
@Repository
public interface UserRepository extends JpaRepository<User,Integer> , JpaSpecificationExecutor<User> {
    //GoodsCategory findByCateName(String cateName);

    List<User> OrderByIdDesc();

    /**
     * @param phone 手机号码
     */
    User findByPhone(String phone);

    User findByUserName(String userName);
}
