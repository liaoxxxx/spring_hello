package com.liaoxx.spring_hello.controller.admin;

import com.liaoxx.spring_hello.dto.admin.AdminAddDto;
import com.liaoxx.spring_hello.dto.admin.AdminDto;
import com.liaoxx.spring_hello.model.AdminModel;
import com.liaoxx.spring_hello.repository.AdminRepository;
import com.liaoxx.spring_hello.repository.GoodsRepository;
import com.liaoxx.spring_hello.service.AdminService;
import com.liaoxx.spring_hello.util.response.JsonResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


//@RestController //注解无法返回视图，默认返回JSON数据。
@CrossOrigin(origins = "*", maxAge = 3600,methods ={RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    AdminService adminService;


    @ResponseBody   //注解无法返回视图，默认返回JSON数据。
    @RequestMapping("/list")
    public JsonResp list() {
        List<AdminModel> adminModelList= adminService. getAdminByPage(1,20);
        return JsonResp.Success("获取管理员数据成功",adminModelList);
    }


    @ResponseBody
    @RequestMapping("/findone/{id}")
    public JsonResp findOne(@PathVariable("id") int  id , Map<String,Object> map){

        AdminDto adminDto= adminService.getAdminDtoById(id);
        map.put("data",adminDto);
        return JsonResp.Success("获取管理员"+ id +"成功",map);
    }


    @ResponseBody
    @RequestMapping("/edit")
    public JsonResp edit(AdminDto adminDto) {
        return adminService.edit( adminDto);
    }

    @ResponseBody
    @RequestMapping("/add")
    public JsonResp add(AdminAddDto adminAddDto) {
        return adminService.add( adminAddDto);
    }

}
