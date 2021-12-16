package com.liaoxx.spring_hello.controller.api.goods;


import com.liaoxx.spring_hello.entity.goods.Goods;
import com.liaoxx.spring_hello.service.goods.GoodsService;
import com.liaoxx.spring_hello.util.response.JsonResp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
@Controller
@RequestMapping("/goodsapi")
public class GoodsApiController {

    @Resource
    GoodsService goodsService;







    @ResponseBody
    @RequestMapping( "/findone/{id}")
    public JsonResp findOne(@PathVariable int id){
        Goods goodsItem= goodsService.findById(id);
        //Map<String ,Object> map =new HashMap();
        if (goodsItem.getId()>0){
            return JsonResp.Success("获取商品数据成功",goodsItem);
        }

        return JsonResp.Success("获取商品数据失败",new Object());
    }


}
