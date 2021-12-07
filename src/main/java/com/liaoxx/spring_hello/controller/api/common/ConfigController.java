package com.liaoxx.spring_hello.controller.api.common;

import com.liaoxx.spring_hello.component.Audience;
import com.liaoxx.spring_hello.dto.api.common.MallConfigDto;
import com.liaoxx.spring_hello.dto.api.user.LoginDto;
import com.liaoxx.spring_hello.param.api.user.LoginParam;
import com.liaoxx.spring_hello.service.CommonService;
import com.liaoxx.spring_hello.service.SystemService;
import com.liaoxx.spring_hello.service.UserService;
import com.liaoxx.spring_hello.util.JwtTokenUtil;
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
@RequestMapping("/xx/common")
public class ConfigController {

    @Resource
    CommonService commonConfig;


    @ResponseBody
    @PostMapping("/config")
    public JsonResp login( ) throws Exception {
        MallConfigDto configDto = commonConfig.commonConfig();
        return JsonResp.Success(configDto);
    }


}
