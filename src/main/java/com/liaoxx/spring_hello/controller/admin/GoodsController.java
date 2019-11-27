package com.liaoxx.spring_hello.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin_goods")
public class GoodsController {



    @ResponseBody
    @CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
    @RequestMapping( "/")
    public Map<String, Object> uploadThumb(@RequestParam(value = "goodsThumb")MultipartFile goodsThumb){
        Map<String,Object> map =new HashMap<>();




        return map;
    }


}
