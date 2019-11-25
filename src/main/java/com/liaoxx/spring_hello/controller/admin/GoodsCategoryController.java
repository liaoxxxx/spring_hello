package com.liaoxx.spring_hello.controller.admin;

import com.liaoxx.spring_hello.dto.admin.GoodsCategoryDto;
import com.liaoxx.spring_hello.entity.GoodsCategory;
import com.liaoxx.spring_hello.service.GoodsCategoryService;
import com.liaoxx.spring_hello.util.JsonResponse;
import com.liaoxx.spring_hello.util.SqlTimeTool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
        return map;
    }






    @ResponseBody
    @CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
    @RequestMapping( "/get_all_category")
    public Map<String,Object> getList(){

      return   JsonResponse.jsonSuccess("get goods category success",
              goodsCategoryService.getList(10,20,"aaaa")
      ) ;
    }

    @ResponseBody
    @CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
    @RequestMapping( "/get_category_by_id")
    public Map<String, Object> getCategoryById(@RequestBody LinkedHashMap<String,String> map){
        GoodsCategory goodsCategory= goodsCategoryService.getById( Integer.parseInt( map.get("id")));

        return   JsonResponse.jsonSuccess("get goods category id : "+map.get("id"),goodsCategory);
    }


    @ResponseBody
    @CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
    @RequestMapping( "/edit_category")
    public Map<String, Object> updateGoodsCategory(@RequestBody GoodsCategoryDto goodsCategoryDto){
        //根据 分类的id 找出数据库存在的记录
        GoodsCategory goodsCategory= goodsCategoryService.getById( goodsCategoryDto.getId());
        //copy dto 的数据 到 goodsCategory(entity)
        BeanUtils.copyProperties(goodsCategoryDto,goodsCategory);
        //设置更新时间
        goodsCategory.setUpdatedAt(SqlTimeTool.getMicroTimeTamp());
        //保存
        goodsCategoryService.update(goodsCategory);
        return   JsonResponse.jsonSuccess("save GoodsCategory id : "+goodsCategoryDto.getId(),goodsCategory);
    }


}
