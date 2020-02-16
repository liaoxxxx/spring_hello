package com.liaoxx.spring_hello.controller.admin;

import com.alibaba.fastjson.JSON;
import com.liaoxx.spring_hello.component.Audience;
import com.liaoxx.spring_hello.entity.Admin;
import com.liaoxx.spring_hello.repository.AdminRepository;
import com.liaoxx.spring_hello.service.AdminLoginService;
import com.liaoxx.spring_hello.util.Base64Util;
import com.liaoxx.spring_hello.util.JsonResponse;
import com.liaoxx.spring_hello.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@RestController //注解无法返回视图，默认返回JSON数据。

@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AdminLoginService adminloginService;

    @Autowired
    Audience audience;

    @Autowired
    Base64Util base64Util;


    //@ResponseBody   //注解无法返回视图，默认返回JSON数据。
    @RequestMapping("/login/html")
    public String Login(Map<String, Object> map) {
        map.put("signInUrl", "/signin");
        return "/admin/manager/login.html";     //返回了视图页面
    }

    @CachePut
    @RequestMapping("/e")
    public String queryUser(Map map) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from  user where id >=355 and id<=358");
        map.put("list", list);
        System.out.println(list);
        return "/admin/manager/querylist";
    }
    @GetMapping("/find/{id}")
    public String findOne(@PathVariable("id") Integer  id ,Map map){
        Admin admin=adminRepository.getOne(id);
        System.out.println(admin);
        map.put("admin",admin);
        return "/admin/manager/find";
    }

    @ResponseBody
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/login")
    public Map<String ,Object> login(@RequestParam(value = "username",required =false) String username,@RequestParam(value = "password",required =false) String password,Map map){

        Admin admin=  adminloginService.findByUsername(username);
        String jwt= JwtTokenUtil.createJWT(admin.getId(),admin.getUsername(),admin.getRole().getRoleName(),audience);
        Map<String ,Object> dataMap = new HashMap<>();
        dataMap.put("token",jwt);
        map.put("data",dataMap);

        return JsonResponse.Success("登陆成功",map);
    }

    @ResponseBody
    @CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
    @RequestMapping("/info")
    public Map<String ,Object> info(@RequestParam(value = "token",required =true) String token,Map map) throws UnsupportedEncodingException {
        Boolean checkBoolean= JwtTokenUtil.checkToken(token,audience.getBase64Secret());


        String payloadAnsSign= token.substring(token.indexOf('.')+1); //第一次裁剪掉 jwt 的hearder 部分 余下 ：payload.sign
        String payloadBase64=payloadAnsSign.substring(0,payloadAnsSign.indexOf('.')); ///第一次裁剪掉 jwt 的sign 部分 余下 ：payload
        String payloadJson=base64Util.decode(payloadBase64); //base64 解码获得 payload 的json字符串

        Map jwtPayloadMap =  JSON.parseObject(payloadJson); //转换成  jwtPayloadEntity

        return JsonResponse.Success("登陆成功",jwtPayloadMap);
    }
}
