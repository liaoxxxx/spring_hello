package com.liaoxx.spring_hello.controller.index;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
@RequestMapping("/redis")
public class RedisTestController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;


    @RequestMapping("/test")
    public String test() {
        stringRedisTemplate.opsForValue().set("name","liaoxx");
        return "a";
    }
}
