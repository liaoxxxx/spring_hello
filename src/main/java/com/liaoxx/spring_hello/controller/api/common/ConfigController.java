package com.liaoxx.spring_hello.controller.api.common;

import com.liaoxx.spring_hello.constants.WechatEnum;
import com.liaoxx.spring_hello.export.api.common.MallConfigExport;
import com.liaoxx.spring_hello.service.common.CommonService;
import com.liaoxx.spring_hello.util.request.HttpRequestUtil;
import com.liaoxx.spring_hello.util.response.JsonResp;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


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
        MallConfigExport configDto = commonService.commonConfig(wxV);
        return JsonResp.Success(configDto);
    }

}
