package com.liaoxx.spring_hello.controller.index;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
@RequestMapping("/rabbit")
@RabbitListener(queues = "default")
public class RabbitReceiveController {

    @RabbitHandler
    @RequestMapping("/defaultReceive")
    public void process(String aaaa) {
        System.out.println();
        System.out.println("Receiver  : " + aaaa);
    }
    @RabbitHandler
    @RequestMapping("/directReceive")
    public void process1(String aaaa) {
        System.out.println("dddddd");
        System.out.println("Receiver  : " + aaaa);
    }

}
