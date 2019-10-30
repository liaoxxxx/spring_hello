package com.liaoxx.spring_hello.controller.index;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


@Controller
@ResponseBody
@RequestMapping("/rabbit")
public class RabbitPublishController {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;


    @RequestMapping("/defaultPublish")
    public void test() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("default", context);
    }
/*
    @RequestMapping("/directPublish")
    public void test2() {
        rabbitTemplate.setExchange("66666");
       // rabbitTemplate.convertAndSend(AmqpConfig.EXCHANGE, AmqpConfig.ROUTINGKEY, content, correlationId);
    }

    @RequestMapping("/RbtDefaultPublish")
    public void test3() {
        rabbitTemplate.convertAndSend("","","" );
    }*/
}



