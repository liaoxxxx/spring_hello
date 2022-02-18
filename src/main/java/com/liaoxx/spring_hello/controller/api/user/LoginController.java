package com.liaoxx.spring_hello.controller.api.user;

import com.liaoxx.spring_hello.export.api.user.LoginExport;
import com.liaoxx.spring_hello.param.api.user.LoginParam;
import com.liaoxx.spring_hello.service.user.UserService;
import com.liaoxx.spring_hello.util.response.JsonResp;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@RestController //注解无法返回视图，默认返回JSON数据。
@CrossOrigin(origins = "*", maxAge = 3600,methods ={RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
@RestController
@RequestMapping("/xx/account")
public class LoginController {

    @Resource
    UserService userService;


    @ResponseBody
    @PostMapping("/login")
    public JsonResp login( @RequestBody LoginParam param) throws Exception {
        LoginExport loginDto = userService.loginMain(param);
        return JsonResp.Success(loginDto, "登陆成功");
    }

    @ResponseBody
    @RequestMapping("/info")
    public JsonResp info(@RequestParam(value = "token",required =true) String token, Map<String, Object> map) throws Exception {
        if (null==token){
            return JsonResp.Error("token can not be null");
        }

        Claims claims = null;
        try{
           // claims= JwtTokenUtil.parseJWT(token,audience.getBase64Secret());
        } catch (Exception eje){

            return JsonResp.Error(eje.getMessage());
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

        return JsonResp.Success(map,"登陆成功");
        //return JsonResp.Success("登陆成功",map);
    }
}
