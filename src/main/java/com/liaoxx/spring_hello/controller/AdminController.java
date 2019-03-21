package com.liaoxx.spring_hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.TimeZone;
import java.util.List;

import java.util.Map;


//@RestController //注解无法返回视图，默认返回JSON数据。
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    //@ResponseBody   //注解无法返回视图，默认返回JSON数据。
    @RequestMapping("/login")
    public String Login(Map<String, Object> map){
        map.put("signInUrl","/signin");
        return "/admin/login.html";     //返回了视图页面
    }
    @RequestMapping("/signin")
    public String SignIn(Map<String, Object> map){
        map.put("foo","bar");
        return "/admin/login.html";     //返回了视图页面
    }
    @RequestMapping("/querylist")
    public List<Map<String,Object>> queryUser(){
      List<Map<String,Object>>  list= jdbcTemplate.queryForList("select * from  user");
      return list;
    }
}
