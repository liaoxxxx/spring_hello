package com.liaoxx.spring_hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {


    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "name:"+name;
    }

    @RequestMapping("/success")
    public String success(Map <String, Object> map){

        map.put("user", Arrays .asList("张三","李四","王五","赵六"));
        map.put("title","输出");
        map.put("imgUrl","/js.png");
        return "success";
    }

}
