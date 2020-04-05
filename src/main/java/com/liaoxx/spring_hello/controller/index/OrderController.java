package com.liaoxx.spring_hello.controller.index;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller(value = "orderapi")
public class OrderController {


    @ResponseBody
    @RequestMapping(value = "/create")
    public Map<String,Object> create(long userId, int goodsId, int addressId, int goodsCount, int goodsDetailId  ){

        return new HashMap<>();
    }
}
