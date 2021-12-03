package com.liaoxx.spring_hello.controller.admin;

import com.liaoxx.spring_hello.config.AppConfig;
import com.liaoxx.spring_hello.dto.admin.GoodsDto;
import com.liaoxx.spring_hello.entity.Goods;
import com.liaoxx.spring_hello.entity.GoodsClassify;
import com.liaoxx.spring_hello.service.GoodsClassifyService;
import com.liaoxx.spring_hello.service.GoodsService;
import com.liaoxx.spring_hello.util.response.JsonResp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping("/admin_goods")
@CrossOrigin(origins = "*", maxAge = 3600)
public class GoodsController {

    @Resource
    GoodsService goodsService;

    @Resource
    GoodsClassifyService goodsClassifyService;
    @ResponseBody
    @RequestMapping( "/add_goods")
    public JsonResp addGoods( GoodsDto goodsDto){
        System.out.println("------------------------------");
        System.out.println(Arrays.toString(goodsDto.getThumb()));

        boolean res=  goodsService.add(goodsDto);
        if (res){
            return JsonResp.Success(goodsDto);
        }
        else {
            return JsonResp.Error("商品添加失败");
        }

    }


    @ResponseBody
    @RequestMapping( "/goods_list")
    public JsonResp list(){

        List<Goods> goodsList= goodsService.list();
        //Map<String ,Object> map =new HashMap();
        if (goodsList.size()>0){
            return JsonResp.Success("获取商品数据成功",goodsList);
        }
        else {
            return JsonResp.Success("获取商品数据失败");
        }


    }


    @ResponseBody
    @RequestMapping( "/findoneWithAllGoodsCate/{id}")
    public JsonResp findOne(@PathVariable int id){
        Goods goodsItem= goodsService.findById(id);
        List<GoodsClassify> goodsCategory=goodsClassifyService.findAll();
        HashMap map =new HashMap();
        map.put("goods",goodsItem);
        map.put("goodsCategoryList",goodsCategory);
        if (goodsItem.getId()>0){
            return JsonResp.Success("获取商品数据成功",map);
        }
       return JsonResp.Success("获取商品数据失败");
    }

    @ResponseBody
    @RequestMapping("test")
    public String test()
    {
        System.out.println("file:"+(new AppConfig().getUploadImagePathWindows()));
        return System.getProperty("src");
    }


}
