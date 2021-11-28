package com.liaoxx.spring_hello.controller.index;

import com.liaoxx.spring_hello.component.Audience;
import com.liaoxx.spring_hello.dto.UserDto;
import com.liaoxx.spring_hello.mapper.UserAddressMapper;
import com.liaoxx.spring_hello.model.UserModel;
import com.liaoxx.spring_hello.service.UserService;
import com.liaoxx.spring_hello.task.PrintfTask;
import com.liaoxx.spring_hello.util.Base64Util;
import com.liaoxx.spring_hello.util.CheckUtil;
import com.liaoxx.spring_hello.util.response.JsonResp;
import com.liaoxx.spring_hello.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600,methods ={RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
@RequestMapping("/userapi")
public class UserController {

    private static final Logger logger= LoggerFactory.getLogger(PrintfTask.class);

    @Autowired
    UserAddressMapper userAddressMapper;

    @Autowired
    UserService userService;

    @Autowired
    Audience audience;

    @Autowired
    Base64Util base64Util;


    @ResponseBody
    @RequestMapping("/login")
    public JsonResp login(@RequestParam(value = "username" ,required = true) String username, Map<String, Object> map){
        UserModel user= userService.findByUsername(username);
        if (CheckUtil.isNull(user)){
            map.put("timestamp", System.currentTimeMillis());
            return JsonResp.Error("该用户不存在") ;
        }
        String token =JwtTokenUtil.createUserJWT(user,audience);
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(user,userDto);
        map.put("token",token);
        map.put("timestamp", System.currentTimeMillis());
        map.put("user",userDto);
        return JsonResp.Success(map) ;
    }
    @ResponseBody
    @RequestMapping("/info")
    public JsonResp info(@RequestParam(value = "token" ,required = true) String token, Map<String, Object> map) throws Exception {
        logger.info("userapi-----/info");
        Claims claims = null;
        try{
             claims= JwtTokenUtil.parseJWT(token,audience.getBase64Secret());
        } catch (Exception eje){

           return JsonResp.Error(eje.getMessage());
        }

        assert claims != null;
        System.out.println(claims.getExpiration());
        int userId=(int) claims.get("userId");
        UserModel user= userService.findByUserId(userId);
        if (CheckUtil.isNull(user)){
            map.put("timestamp", System.currentTimeMillis());
            return JsonResp.Error("该用户不存在") ;
        }
        //隐藏部分user 字段
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(user,userDto);
        map.put("user",userDto);
        return JsonResp.Success(map,"获取用户信息成功") ;
    }
}
