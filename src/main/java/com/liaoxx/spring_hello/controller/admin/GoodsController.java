package com.liaoxx.spring_hello.controller.admin;

import com.liaoxx.spring_hello.config.AppConfig;
import com.liaoxx.spring_hello.dto.admin.GoodsDto;
import com.liaoxx.spring_hello.entity.Goods;
import com.liaoxx.spring_hello.entity.GoodsCategory;
import com.liaoxx.spring_hello.service.GoodsCategoryService;
import com.liaoxx.spring_hello.service.GoodsService;
import com.liaoxx.spring_hello.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/admin_goods")
@CrossOrigin(origins = "*", maxAge = 3600)
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    GoodsCategoryService goodsCateService;
    @ResponseBody
    @RequestMapping( "/add_goods")
    public Map<String, Object> addGoods( GoodsDto goodsDto){
        System.out.println("------------------------------");
        System.out.println(goodsDto.getThumb());

        boolean res=  goodsService.add(goodsDto);
        if (res){
            return JsonResponse.Success("商品添加成功",goodsDto);
        }
        else {
            return JsonResponse.Error("商品添加失败",goodsDto);
        }

    }


    @ResponseBody
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
    @RequestMapping( "/findoneWithAllGoodsCate/{id}")
    public Map<String, Object> findOne(@PathVariable int id){
        Goods goodsItem= goodsService.findById(id);
        List<GoodsCategory> goodsCategory=goodsCateService.findAll();
        Map<String ,Object> map =new HashMap();
        map.put("goods",goodsItem);
        map.put("goodsCategoryList",goodsCategory);
        if (goodsItem.getId()>0){
            return JsonResponse.Success("获取商品数据成功",map);
        }
       return JsonResponse.Success("获取商品数据失败",null);
    }

    @ResponseBody
    @RequestMapping("test")
    public String test()
    {
        System.out.println("file:"+(new AppConfig().getUploadImagePathWindows()));
        return System.getProperty("src");
    }


}
