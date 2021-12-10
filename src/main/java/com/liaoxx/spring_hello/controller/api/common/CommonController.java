package com.liaoxx.spring_hello.controller.api.common;

import com.liaoxx.spring_hello.dto.api.common.MallConfigDto;
import com.liaoxx.spring_hello.param.api.common.PageBasicsParam;
import com.liaoxx.spring_hello.service.common.CommonService;
import com.liaoxx.spring_hello.util.response.JsonResp;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


//@RestController //注解无法返回视图，默认返回JSON数据。
@CrossOrigin(origins = "*", maxAge = 3600,methods ={RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
@RestController
@RequestMapping("/xx/common")
public class CommonController {

    @Resource
    CommonService commonService;


    /**
     *  首页基础配置
     *
     *
    * */
    @ResponseBody
    @GetMapping("/page/basics")
    public JsonResp pageBasics(HttpServletRequest request, @RequestBody PageBasicsParam pageBasicsParam)  {
        MallConfigDto configDto = commonService.commonConfig(wxV);
        return JsonResp.Success(configDto);
    }

}
