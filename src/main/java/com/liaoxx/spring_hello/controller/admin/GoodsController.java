package com.liaoxx.spring_hello.controller.admin;


import com.liaoxx.spring_hello.dto.admin.GoodsDto;
import com.liaoxx.spring_hello.entity.Goods;
import com.liaoxx.spring_hello.service.GoodsService;
import com.liaoxx.spring_hello.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
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

        boolean res=  goodsService.add(goodsDto);
        Map<String ,Object> map =new HashMap();
        if (res){
            return JsonResponse.Success("商品添加成功",map);
        }
        else {
            return JsonResponse.Error("商品添加失败",map);
        }

    }


    @ResponseBody
    @CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
    @RequestMapping( "/goods_list")
    public Map<String, Object> list(){

        List<Goods> goodsList= goodsService.list();
        //Map<String ,Object> map =new HashMap();
        if (goodsList.size()>0){
            return JsonResponse.Success("获取商品数据成功",goodsList);
        }
        else {
            return JsonResponse.Success("获取商品数据失败",new Object());
        }


    }


}
