package com.liaoxx.spring_hello.controller.api.goods;

import com.liaoxx.spring_hello.service.GoodsService;
import com.liaoxx.spring_hello.util.response.JsonResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public JsonResp list(){
        //goodsService.list()
        //return JsonResp.Success(data)
        return null;
    }
}
