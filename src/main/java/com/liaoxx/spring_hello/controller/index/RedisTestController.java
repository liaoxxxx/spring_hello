package com.liaoxx.spring_hello.controller.index;


import com.liaoxx.spring_hello.repository.BiliRecommendVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.cglib.beans.BeanMap;



@Controller
@ResponseBody
@RequestMapping("/redis")
public class RedisTestController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    BiliRecommendVideoRepository recommendVideoRepository;


    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        stringRedisTemplate.opsForValue().set("names","liaoxxxx");
        System.out.println(stringRedisTemplate.opsForValue().get("names"));
        System.out.println(BeanMap.create( recommendVideoRepository.getOne(1)));
        //redisTemplate.opsForHash().putAll("biliRcmd01",BeanMap.create( recommendVideoRepository.getOne(1)));
        //System.out.println(redisTemplate.opsForHash().values("biliRcmd01"));
        return "a";
    }


}
