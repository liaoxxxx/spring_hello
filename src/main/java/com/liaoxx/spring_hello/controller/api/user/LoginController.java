package com.liaoxx.spring_hello.controller.api.user;

import com.liaoxx.spring_hello.component.Audience;
import com.liaoxx.spring_hello.dto.api.user.LoginDto;
import com.liaoxx.spring_hello.param.api.user.Login;
import com.liaoxx.spring_hello.service.UserService;
import com.liaoxx.spring_hello.util.JwtTokenUtil;
import com.liaoxx.spring_hello.util.response.JsonResp;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@RestController //注解无法返回视图，默认返回JSON数据。
@CrossOrigin(origins = "*", maxAge = 3600,methods ={RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
@RequestMapping("/xx/account")
public class LoginController {

    @Resource
    UserService userService;
    private Audience audience;

    @ResponseBody
    @RequestMapping("/login")
    public JsonResp login(HttpServletRequest request, @RequestBody Login param){
        LoginDto loginDto = new LoginDto();
        String mms = request.getParameter("mms");
        loginDto = userService.loginMain(mms, param);
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
            claims= JwtTokenUtil.parseJWT(token,audience.getBase64Secret());
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
