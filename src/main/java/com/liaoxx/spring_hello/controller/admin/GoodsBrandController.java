package com.liaoxx.spring_hello.controller.admin;

import com.liaoxx.spring_hello.entity.GoodsBrand;
import com.liaoxx.spring_hello.service.GoodsBrandService;
import com.liaoxx.spring_hello.util.response.JsonResp;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//@RestController //注解无法返回视图，默认返回JSON数据。
@CrossOrigin(origins = "*", maxAge = 3600,methods ={RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
@Controller
@RequestMapping("/admin")
public class GoodsBrandController {

    @Resource
    GoodsBrandService brandService;


    @ResponseBody   //注解无法返回视图，默认返回JSON数据。
    @RequestMapping("/brandList")
    public JsonResp list() {

        Page<GoodsBrand> brandModels= brandService.list(1,20);
        return JsonResp.Success("获取品牌数据成功",brandModels);
    }


   /* @ResponseBody
    @RequestMapping("/findBrand/{id}")
    public JsonResp findOne(@PathVariable("id") int  id , Map map){

        AdminDto adminDto= brandService.getBrandDtoById(id);
        map.put("data",adminDto);
        return JsonResp.Success("获取管理员"+ id +"成功",map);
    }*/


   /* @ResponseBody
    @RequestMapping("/editBrand")
    public JsonResp edit(AdminDto adminDto) {
        return brandService.edit( adminDto);
    }

    @ResponseBody
    @RequestMapping("/addBrand")
    public JsonResp add(AdminAddDto adminAddDto) {
        return brandService.add( adminAddDto);
    }*/

}
