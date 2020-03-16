package com.liaoxx.spring_hello.controller.index;

import com.liaoxx.spring_hello.mapper.UserAddressMapper;
import com.liaoxx.spring_hello.mapper.UserMapper;
import com.liaoxx.spring_hello.model.UserModel;
import com.liaoxx.spring_hello.service.UserService;
import com.liaoxx.spring_hello.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:9527", maxAge = 3600,methods ={RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
@RequestMapping("/user")
public class UserController {
    //注入Mapper
    @Autowired
    private UserMapper userMapper;

    @Autowired
    UserAddressMapper userAddressMapper;

    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public String list(){
        List<UserModel> userModelList= userMapper.getAll();
        for (UserModel userItem: userModelList) {
            System.out.println(userItem.toString());
        }
        return "success";
    }
    @ResponseBody
    @RequestMapping("/login")
    public Map<String, Object> login(@RequestParam(value = "username" ,required = true) String username, Map<String, Object> map){
        UserModel user= userMapper.getByUserName(username);
        System.out.println(user.toString());
        map.put("user",user);
        return JsonResponse.Success("success",map) ;
    }
}
