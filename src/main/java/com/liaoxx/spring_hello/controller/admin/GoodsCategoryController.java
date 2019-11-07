package com.liaoxx.spring_hello.controller.admin;

//import com.liaoxx.spring_hello.repository.GoodsCategoryRepository;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liaoxx.spring_hello.dto.admin.GoodsCategoryDto;
import com.liaoxx.spring_hello.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin_goods")
public class GoodsCategoryController {

    @Autowired
    GoodsCategoryService goodsCategoryService;

    @RequestMapping("/list")
    public void list(){
        //return  "/mobile/index";
    }

    @ResponseBody
    @CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
    @RequestMapping( "/add_category")
    public Map<String, Object> addGoodsCategory(@RequestBody GoodsCategoryDto goodsCategoryDto){

        System.out.println(goodsCategoryDto.getCateName());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        Map<String,Object> map =new HashMap<>();
        map.put("code",200);
        map.put("msg","success");
        return map;
    }

}
