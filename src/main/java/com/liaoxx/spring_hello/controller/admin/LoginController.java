package com.liaoxx.spring_hello.controller.admin;

import com.alibaba.fastjson.JSON;
import com.liaoxx.spring_hello.entity.Admin;
import com.liaoxx.spring_hello.repository.AdminRepository;
import com.liaoxx.spring_hello.service.AdminLoginService;
import com.liaoxx.spring_hello.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "username",required =true) String username,@RequestParam(value = "password",required =true) String password,Map map){

        Admin admin=  adminloginService.findByUsername(username);
        map.put("msg","bar");
        map.put("name","liaoxx");
        map.put("data",admin);
        String jsonStr=JSON.toJSONString(map);
        return jsonStr;
    }
}