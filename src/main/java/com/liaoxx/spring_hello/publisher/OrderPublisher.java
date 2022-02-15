package com.liaoxx.spring_hello.publisher;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class OrderPublisher {

    @Resource
    RabbitTemplate rabbitTemplate;

    public void OrderCreate(String object, Message message, Channel channel) {


        Map<String, Object> map = new HashMap<>();
        map.put("sendTime", (new Date().toString()));
        map.put("msg", "push2OrderQueue---test");
        rabbitTemplate.convertAndSend( map);
    }
}
