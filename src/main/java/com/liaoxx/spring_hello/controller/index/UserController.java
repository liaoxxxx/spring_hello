package com.liaoxx.spring_hello.controller.index;

import com.liaoxx.spring_hello.entity.User;
import com.liaoxx.spring_hello.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    //private UserMapper userMapper;

    @RequestMapping("/add")
    public String addUser(){

       // User user=new User();
       // user.setUsername("liaoxx");
       // user.setPasswd("liao993501756");
        //user.setSalt("adwed");
        //userMapper.install(user);
        return "success";
    }
}
