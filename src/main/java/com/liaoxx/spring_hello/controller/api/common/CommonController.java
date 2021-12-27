package com.liaoxx.spring_hello.controller.api.common;

import com.liaoxx.spring_hello.export.api.common.CommonAdListExport;
import com.liaoxx.spring_hello.export.api.common.PageBasicsExport;
import com.liaoxx.spring_hello.param.api.ApiParamMap;
import com.liaoxx.spring_hello.param.api.common.PageBasicsParam;
import com.liaoxx.spring_hello.service.common.CommonAdService;
import com.liaoxx.spring_hello.service.common.CommonService;
import com.liaoxx.spring_hello.util.response.JsonResp;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


//@RestController //注解无法返回视图，默认返回JSON数据。
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
@RestController
@RequestMapping("/xx/common")
public class CommonController {

    @Resource
    CommonService commonService;

    @Resource
    CommonAdService adService;

    /**
     * 首页基础配置
     */
    @ResponseBody
    @GetMapping("/page/basics")
    public JsonResp pageBasics(HttpServletRequest request,PageBasicsParam pageBasicsParam) {
        PageBasicsExport pageBasics = commonService.getPageBasics(request,pageBasicsParam);
        return JsonResp.Success(pageBasics);
    }

    /**
     * 获取广告
     */
    @GetMapping("/ad")
    public JsonResp advertising(HttpServletRequest request, PageBasicsParam pageBasicsParam) {
        ApiParamMap paramMap = new ApiParamMap(request.getParameterMap());
        CommonAdListExport adListDto = adService.list(paramMap.paramMap, paramMap.page, paramMap.pagesize);
        return JsonResp.Success(adListDto);
    }


}
