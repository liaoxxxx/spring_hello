package com.liaoxx.spring_hello.service;

import com.liaoxx.spring_hello.consts.LoginType;
import com.liaoxx.spring_hello.dto.api.user.LoginDto;
import com.liaoxx.spring_hello.entity.User;
import com.liaoxx.spring_hello.param.api.user.LoginParamI;
import com.liaoxx.spring_hello.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

@Service
public class UserService {
    @Resource
    UserRepository userRepository;

    public User findByUsername(String userName){
        return userRepository.findByUsername(userName);
    }

    public User findByUserId(int userId){
        return userRepository.getById(userId);
    }

    public LoginDto loginMain(HttpServletRequest request){
        Map<String,String[]> parameterMap=request.getParameterMap();
        System.out.println("parameterMap = " + Arrays.toString(parameterMap.get("mms")));
        LoginParamI param=new LoginParamI();
        LoginDto loginDto= new LoginDto();
        if (Objects.equals(param.mms, LoginType.PHONE)){
            loginDto=   this.loginByPhone(param.phone, param.password);
        }
        return loginDto;
    }

    public  LoginDto loginByPhone(String phone , String password){
        //userMapper.findByUserName()
        return new LoginDto();
    }
}
