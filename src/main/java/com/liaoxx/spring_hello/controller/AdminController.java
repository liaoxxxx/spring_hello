package com.liaoxx.spring_hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return "/admin/manager/login.html";     //返回了视图页面
    }

    @RequestMapping("/querylist")
    public String queryUser(Map map){
      List<Map<String,Object>>  list= jdbcTemplate.queryForList("select * from  user where id >=355 and id<=358");
      map.put("list",list);
      System.out.println(list);
      return "/admin/manager/querylist";
    }
}
