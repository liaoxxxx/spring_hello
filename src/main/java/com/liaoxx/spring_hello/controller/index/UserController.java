package com.liaoxx.spring_hello.controller.index;

import com.liaoxx.spring_hello.entity.User;
import com.liaoxx.spring_hello.mapper.UserMapper;
import com.liaoxx.spring_hello.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/add")
    public String addUser(){

       // User user=new User();
       // user.setUsername("liaoxx");
       // user.setPasswd("liao993501756");
        //user.setSalt("adwed");
        //userMapper.install(user);
        return "success";
    }

    @RequestMapping("/list")
    public String list(){
        List<UserModel> userModelList= userMapper.getAll();
        for (UserModel userIte: userModelList) {
            System.out.println(userIte.toString());
        }
        System.out.println();
        return "success";
    }
}
