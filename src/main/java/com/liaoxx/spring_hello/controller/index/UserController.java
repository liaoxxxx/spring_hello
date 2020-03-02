package com.liaoxx.spring_hello.controller.index;

import com.liaoxx.spring_hello.mapper.UserAddressMapper;
import com.liaoxx.spring_hello.mapper.UserMapper;
import com.liaoxx.spring_hello.model.UserAddressModel;
import com.liaoxx.spring_hello.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //注入Mapper
    @Autowired
    private UserMapper userMapper;

    @Autowired
    UserAddressMapper userAddressMapper;

    @RequestMapping("/list")
    public String list(){
        List<UserModel> userModelList= userMapper.getAll();
        for (UserModel userItem: userModelList) {
            System.out.println(userItem.toString());
        }
        return "success";
    }
}
