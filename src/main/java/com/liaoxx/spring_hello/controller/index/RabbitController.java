package com.liaoxx.spring_hello.controller.index;


import com.liaoxx.spring_hello.repository.BiliRecommendVideoRepository;
import org.junit.Test;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@ResponseBody
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    AmqpTemplate amqpTemplate;

    @RequestMapping("/test1")
    public void test(){
        Map<String,Object> map=new HashMap();
        map.put("name","liaoxx");
        amqpTemplate.convertAndSend("test",map);
    }

}
