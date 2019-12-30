package com.liaoxx.spring_hello.controller.admin;


import com.google.common.collect.Multiset;
import com.liaoxx.spring_hello.config.AppConfig;
import com.liaoxx.spring_hello.dto.admin.GoodsDto;
import com.liaoxx.spring_hello.entity.Goods;
import com.liaoxx.spring_hello.service.GoodsService;
import com.liaoxx.spring_hello.util.JsonResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Controller
@RequestMapping("/admin_goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @ResponseBody
    @CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
    @RequestMapping( "/add_goods")
    public Map<String, Object> addGoods( GoodsDto goodsDto){
        System.out.println("------------------------------");
        System.out.println(goodsDto.getName());
        boolean res=  goodsService.add(goodsDto);

        Map<String ,Object> map =new HashMap();
        if (res){
            return JsonResponse.Success("商品添加成功",goodsDto);
        }
        else {
            return JsonResponse.Error("商品添加失败",goodsDto);
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


    @ResponseBody
    @CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
    @RequestMapping( "/findone/{id}")
    public Map<String, Object> findOne(@PathVariable int id){


        Goods goodsItem= goodsService.findById(id);
        //Map<String ,Object> map =new HashMap();
        if (goodsItem.getId()>0){
            return JsonResponse.Success("获取商品数据成功",goodsItem);
        }

       return JsonResponse.Success("获取商品数据失败",new Object());
    }

    @ResponseBody
    @RequestMapping("test")
    public String test()
    {
        System.out.println("file:"+(new AppConfig().getUploadImagePathWindows()));
        return System.getProperty("src");
    }


}
