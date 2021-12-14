package com.liaoxx.spring_hello.controller.api.goods;

import com.liaoxx.spring_hello.param.api.goods.GoodsListParam;
import com.liaoxx.spring_hello.service.GoodsService;
import com.liaoxx.spring_hello.util.response.JsonResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Map;

@RequestMapping("/api/goods")
public class GoodsController {

    @Resource
    GoodsService goodsService;

    @GetMapping(value = "/list")
    public JsonResp list(@RequestBody GoodsListParam goodsListParam){
        goodsService.list(goodsListParam);
        //return JsonResp.Success(data)
        return null;
    }
}
