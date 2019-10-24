package com.liaoxx.spring_hello.controller.index;


import org.springframework.amqp.core.AmqpTemplate;
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

    @RequestMapping("/defaultPublish")
    public void test() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("hello", context);
    }

    /*@RequestMapping("/directPublish")
    public void test2() {
        amqpTemplate.convertAndSend("testEx", "","the direct message");
    }*/
}



