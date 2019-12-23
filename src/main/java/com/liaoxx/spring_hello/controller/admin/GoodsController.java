package com.liaoxx.spring_hello.controller.admin;


import com.liaoxx.spring_hello.dto.admin.GoodsDto;
import com.liaoxx.spring_hello.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin_goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @ResponseBody
    @CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
    @RequestMapping( "/add_goods")
    public Map<String, Object> addGoods(@RequestBody GoodsDto goodsDto){

        goodsService.add(goodsDto);



        Map<String ,Object> map =new HashMap();
        return map;
    }


}
