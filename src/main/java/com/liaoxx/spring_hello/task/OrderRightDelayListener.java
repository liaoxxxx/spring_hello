package com.liaoxx.spring_hello.task;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



@Slf4j
@Component
@RabbitListener(queues = "order_right")
public class OrderRightDelayListener {



    @RabbitHandler
    public void process(String msgOrderRight) {
        System.out.println("------------ OrderRightDelayListener process  Receiver  : " +msgOrderRight);
    }
}




