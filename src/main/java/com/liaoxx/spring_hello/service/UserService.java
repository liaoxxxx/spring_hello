package com.liaoxx.spring_hello.service;

import com.liaoxx.spring_hello.dto.api.user.LoginDto;
import com.liaoxx.spring_hello.mapper.UserMapper;
import com.liaoxx.spring_hello.model.UserModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public UserModel findByUsername(String userName){
        return userMapper.findByUserName(userName);
    }

    public UserModel findByUserId(long userId){
        return userMapper.getById(userId);
    }

    public LoginDto login(String mms ,String phone ,String password){
        return new LoginDto();
    }
}
