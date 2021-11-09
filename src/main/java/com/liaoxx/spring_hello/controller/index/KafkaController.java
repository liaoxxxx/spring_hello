package com.liaoxx.spring_hello.controller.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class KafkaController {


    @Autowired
    private KafkaTemplate template;

    @GetMapping("/send/{input}")
    public void sendFoo(@PathVariable String input) {
        template.executeInTransaction(t ->{
            t.send("topic_input","kl");
            if("error".equals(input)){
                throw new RuntimeException("failed");
            }
            t.send("topic_input","ckl");
            return true;
        });
    }
}