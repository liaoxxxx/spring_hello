package com.liaoxx.spring_hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


//@RestController //注解无法返回视图，默认返回JSON数据。
@Controller
public class AdminController {
    //@ResponseBody   //注解无法返回视图，默认返回JSON数据。
    @RequestMapping("/admin/login")
    public String Login(Map<String, Object> map){
        map.put("signInUrl","/admin/signin");
        return "/admin/login.html";     //返回了视图页面
    }
    @RequestMapping("/admin/signin")
    public String SignIn(Map<String, Object> map){
        map.put("foo","bar");
        return "/admin/login.html";     //返回了视图页面
    }
}
