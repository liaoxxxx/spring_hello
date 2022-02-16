package com.liaoxx.spring_hello.controller.api.test;

import com.liaoxx.spring_hello.exception.ServiceException;
import com.liaoxx.spring_hello.export.api.goods.GoodsDetailExport;
import com.liaoxx.spring_hello.export.api.goods.GoodsListExport;
import com.liaoxx.spring_hello.param.api.ApiParamMap;
import com.liaoxx.spring_hello.param.api.goods.GoodsListParam;
import com.liaoxx.spring_hello.publisher.OrderPublisher;
import com.liaoxx.spring_hello.service.goods.GoodsService;
import com.liaoxx.spring_hello.util.response.JsonResp;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600,methods ={RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
@RestController
@RequestMapping("/xx/test/rabbitmq")
public class Rabbitmq {

    @Resource
    OrderPublisher orderPublisher;



    @GetMapping(value = "/push2OrderQueue")
    public JsonResp push2OrderQueue(HttpServletRequest request)  {
        orderPublisher.OrderCreate();
        return  null;
    }
}



