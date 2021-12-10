package com.liaoxx.spring_hello.controller.api.common;

import com.liaoxx.spring_hello.component.Audience;
import com.liaoxx.spring_hello.constants.SystemEnum;
import com.liaoxx.spring_hello.constants.WechatEnum;
import com.liaoxx.spring_hello.dto.api.common.MallConfigDto;
import com.liaoxx.spring_hello.dto.api.user.LoginDto;
import com.liaoxx.spring_hello.param.api.user.LoginParam;
import com.liaoxx.spring_hello.service.CommonService;
import com.liaoxx.spring_hello.service.SystemService;
import com.liaoxx.spring_hello.service.UserService;
import com.liaoxx.spring_hello.util.JwtTokenUtil;
import com.liaoxx.spring_hello.util.request.HttpRequestUtil;
import com.liaoxx.spring_hello.util.response.JsonResp;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@RestController //注解无法返回视图，默认返回JSON数据。
@CrossOrigin(origins = "*", maxAge = 3600,methods ={RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
@RestController
@RequestMapping("/xx/common")
public class ConfigController {

    @Resource
    CommonService commonService;


    @ResponseBody
    @GetMapping("/configure")
    public JsonResp configure(HttpServletRequest request )  {
        String wxV = HttpRequestUtil.getHeader(request, WechatEnum.MpWxV);
        MallConfigDto configDto = commonService.commonConfig(wxV);
        return JsonResp.Success(configDto);
    }

}
