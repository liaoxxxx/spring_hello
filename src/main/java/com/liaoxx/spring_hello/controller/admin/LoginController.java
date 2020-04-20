package com.liaoxx.spring_hello.controller.admin;

import com.liaoxx.spring_hello.component.Audience;
import com.liaoxx.spring_hello.entity.Admin;
import com.liaoxx.spring_hello.repository.AdminRepository;
import com.liaoxx.spring_hello.service.AdminLoginService;
import com.liaoxx.spring_hello.util.Base64Util;
import com.liaoxx.spring_hello.util.CheckUtil;
import com.liaoxx.spring_hello.util.JsonResponse;
import com.liaoxx.spring_hello.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//@RestController //注解无法返回视图，默认返回JSON数据。
@CrossOrigin(origins = "*", maxAge = 3600,methods ={RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AdminLoginService adminloginService;

    @Autowired
    Audience audience;

    @Autowired
    Base64Util base64Util;


    //@ResponseBody   //注解无法返回视图，默认返回JSON数据。
    @RequestMapping("/login/html")
    public String Login(Map<String, Object> map) {
        map.put("signInUrl", "/signin");
        return "/admin/manager/login.html";     //返回了视图页面
    }

    @CachePut
    @RequestMapping("/e")
    public String queryUser(Map<String, List<Map<String, Object>>> map) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from  user where id >=355 and id<=358");
        map.put("list", list);
        System.out.println(list);
        return "/admin/manager/querylist";
    }
    @GetMapping("/find/{id}")
    public String findOne(@PathVariable("id") Integer  id , Map<String, Admin> map){
        Admin admin=adminRepository.getOne(id);
        System.out.println(admin);
        map.put("admin",admin);
        return "/admin/manager/find";
    }

    @ResponseBody
    @RequestMapping("/login")
    public Map<String ,Object> login(@RequestParam(value = "username",required =false) String username, @RequestParam(value = "password",required =false) String password, Map<String, String> map){
        //管理员
        System.out.println(username);
        Admin admin=  adminloginService.findByUsername(username);
        if (CheckUtil.isNull(admin)){
            return JsonResponse.Error("用戶不存在",map);
        }
        //角色 列表
        List<Map<String, Object>> roleList=adminRepository.getRoleNames(admin.getId());

        String jwt= JwtTokenUtil.createJWT(admin, roleList,audience);
        map.put("token",jwt);


        return JsonResponse.Success("登陆成功",map);
    }

    @ResponseBody
    @RequestMapping("/info")
    public Map<String ,Object> info(@RequestParam(value = "token",required =true) String token, Map<String, Object> map) throws Exception {
        if (null==token){
            return JsonResponse.Error("token can not be null",null);
        }

        Claims claims = null;
        try{
            claims= JwtTokenUtil.parseJWT(token,audience.getBase64Secret());
        } catch (Exception eje){

            return JsonResponse.Error(eje.getMessage(),"86", "jwt001");
        }
        List<Map<String,String>> roleListMap= (List<Map<String,String>>) claims.get("roles");
        ArrayList<String> roleList=new ArrayList<String>();
        for (Map<String,String> roleItem: roleListMap) {
            //System.out.println(roleItem.get("roleName"));
            roleList.add(roleItem.get("roleName"));
        }
        map.put("roles",roleList);
        map.put("name",  claims.get("name"));
        map.put("avatar",  claims.get("avatar"));
        map.put("introduction",  claims.get("introduction"));

        return JsonResponse.Success("登陆成功",map);
        //return JsonResponse.Success("登陆成功",map);
    }
}
