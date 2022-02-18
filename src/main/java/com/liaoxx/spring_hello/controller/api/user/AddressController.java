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
@RequestMapping("/xx/account/address")
public class AddressController {

    @Resource
    UserService userService;


    @ResponseBody
    @GetMapping("/list")
    public JsonResp List( @RequestBody LoginParam param) throws Exception {
        LoginExport loginDto = userService.loginMain(param);
        return JsonResp.Success(loginDto, "登陆成功");
    }

}
