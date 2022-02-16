package com.liaoxx.spring_hello.publisher;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liaoxx.spring_hello.constants.QueueEnum;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class OrderPublisher {

    @Resource
    AmqpTemplate rabbitTemplate;

    public void OrderCreate() {
        System.out.println("-----------------OrderPublisher.OrderCreate--------------");

        Map<String, Object> map = new HashMap<>();
        map.put("sendTime", (new Date().toString()));
        map.put("msg", "push2OrderQueue---test");
        rabbitTemplate.convertAndSend(QueueEnum.TypeQueueOrderRight,  JSONObject.toJSONString(map));
    }
}
