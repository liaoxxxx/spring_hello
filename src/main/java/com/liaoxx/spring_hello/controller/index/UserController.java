package com.liaoxx.spring_hello.controller.index;

import com.liaoxx.spring_hello.component.Audience;
import com.liaoxx.spring_hello.dto.UserDto;
import com.liaoxx.spring_hello.entity.SysRole;
import com.liaoxx.spring_hello.mapper.UserAddressMapper;
import com.liaoxx.spring_hello.mapper.UserMapper;
import com.liaoxx.spring_hello.model.UserModel;
import com.liaoxx.spring_hello.service.UserService;
import com.liaoxx.spring_hello.util.Base64Util;
import com.liaoxx.spring_hello.util.JsonResponse;
import com.liaoxx.spring_hello.util.JwtTokenUtil;
import org.springframework.beans.BeanUtils;
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

    @Autowired
    Audience audience;

    @Autowired
    Base64Util base64Util;

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
        UserModel user= userService.findByUsername(username);
        String token =JwtTokenUtil.createUserJWT(user,audience);
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(user,userDto);
        map.put("token",token);
        map.put("timestamp", System.currentTimeMillis());
        map.put("user",userDto);
        return JsonResponse.Success("success",map) ;
    }
}
