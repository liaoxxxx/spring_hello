package com.liaoxx.spring_hello.service;

import com.liaoxx.spring_hello.mapper.UserMapper;
import com.liaoxx.spring_hello.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public UserModel findByUsername(String userName){
        return userMapper.getByUserName(userName);
    }
}
