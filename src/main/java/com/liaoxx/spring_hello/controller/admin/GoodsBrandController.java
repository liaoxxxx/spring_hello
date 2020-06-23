package com.liaoxx.spring_hello.controller.admin;

import com.liaoxx.spring_hello.dto.admin.AdminAddDto;
import com.liaoxx.spring_hello.dto.admin.AdminDto;
import com.liaoxx.spring_hello.mapper.GoodsBrandMapper;
import com.liaoxx.spring_hello.model.AdminModel;
import com.liaoxx.spring_hello.model.GoodsBrandModel;
import com.liaoxx.spring_hello.service.GoodsBrandService;
import com.liaoxx.spring_hello.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
//@RestController //注解无法返回视图，默认返回JSON数据。
@CrossOrigin(origins = "*", maxAge = 3600,methods ={RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
@Controller
@RequestMapping("/admin")
public class GoodsBrandController {

    @Autowired
    GoodsBrandService brandService;


    @ResponseBody   //注解无法返回视图，默认返回JSON数据。
    @RequestMapping("/brandList")
    public Map<String ,Object> list() {
        List<GoodsBrandModel> brandModels= brandService.getBrandByPage(1,20);
        return JsonResponse.Success("获取品牌数据成功",brandModels);
    }


   /* @ResponseBody
    @RequestMapping("/findBrand/{id}")
    public Map<String, Object> findOne(@PathVariable("id") int  id , Map map){

        AdminDto adminDto= brandService.getBrandDtoById(id);
        map.put("data",adminDto);
        return JsonResponse.Success("获取管理员"+ id +"成功",map);
    }*/


   /* @ResponseBody
    @RequestMapping("/editBrand")
    public Map<String, Object> edit(AdminDto adminDto) {
        return brandService.edit( adminDto);
    }

    @ResponseBody
    @RequestMapping("/addBrand")
    public Map<String, Object> add(AdminAddDto adminAddDto) {
        return brandService.add( adminAddDto);
    }*/

}
