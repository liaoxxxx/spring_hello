package com.liaoxx.spring_hello.controller.admin;

import com.liaoxx.spring_hello.dto.admin.GoodsCategoryDto;
import com.liaoxx.spring_hello.entity.GoodsCategory;
import com.liaoxx.spring_hello.service.GoodsCategoryService;
import com.liaoxx.spring_hello.util.response.JsonResp;
import com.liaoxx.spring_hello.util.SqlTimeTool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/admin_goods")
public class GoodsCategoryController {

    @Autowired
    GoodsCategoryService goodsCategoryService;

    @RequestMapping("/list")
    public void list(){
        //return  "/mobile/index";
    }

    @ResponseBody
    @RequestMapping( "/add_category")
    public JsonResp addGoodsCategory(@RequestBody GoodsCategoryDto goodsCategoryDto){
        Map<String,Object> map =new HashMap<>();

        if (goodsCategoryService.add(goodsCategoryDto)){

            map.put("code",200);
            map.put("msg","success");
            map.put("data",goodsCategoryDto);
        }
        else {

            map.put("code",500);
            map.put("msg","error");
            map.put("data",goodsCategoryDto);
        }
      return   JsonResp.Success("save GoodsCategory id : "+goodsCategoryDto.getId(),map);
    }

    @ResponseBody
    @RequestMapping( "/get_all_category")
    public JsonResp getList(){

      return   JsonResp.Success("get goods category success",
              goodsCategoryService.getList(10,20,"aaaa")
      ) ;
    }

    @ResponseBody
    @RequestMapping( "/getAllGoodsCate")
    public JsonResp getCategoryById(){
        //所有的 商品分类
        List<GoodsCategory> goodsCategoryList= goodsCategoryService.findAll();
        Map<String, List<GoodsCategory>> map =new HashMap<>();
        map.put("goodsCateList",goodsCategoryList);
        return   JsonResp.Success("get goodsCate success",map);
    }


    @ResponseBody
    @CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
    @RequestMapping( "/edit_category")
    public JsonResp updateGoodsCategory(@RequestBody GoodsCategoryDto goodsCategoryDto){
        //根据 分类的id 找出数据库存在的记录
        GoodsCategory goodsCategory= goodsCategoryService.getById( goodsCategoryDto.getId());
        //copy dto 的数据 到 goodsCategory(entity)
        BeanUtils.copyProperties(goodsCategoryDto,goodsCategory);
        //设置更新时间
        goodsCategory.setUpdatedAt(SqlTimeTool.getMicroTimeTamp());
        //保存
        goodsCategoryService.update(goodsCategory);
        return   JsonResp.Success("save GoodsCategory id : "+goodsCategoryDto.getId(),goodsCategory);
    }


}
