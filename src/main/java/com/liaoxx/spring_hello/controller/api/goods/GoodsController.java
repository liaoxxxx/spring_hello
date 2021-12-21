package com.liaoxx.spring_hello.controller.api.goods;

import com.liaoxx.spring_hello.dto.api.goods.GoodsListDto;
import com.liaoxx.spring_hello.param.api.ApiParamMap;
import com.liaoxx.spring_hello.param.api.goods.GoodsListParam;
import com.liaoxx.spring_hello.service.goods.GoodsService;
import com.liaoxx.spring_hello.util.response.JsonResp;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@CrossOrigin(origins = "*", maxAge = 3600,methods ={RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
@RestController
@RequestMapping("/xx/goods")
public class GoodsController {

    @Resource
    GoodsService goodsService;

    @GetMapping(value = "/list")
    public JsonResp list(HttpServletRequest request, GoodsListParam goodsListParam){
        ApiParamMap paramMap=new ApiParamMap(request.getParameterMap());
        GoodsListDto goodsListDto =goodsService.list(paramMap.paramMap,paramMap.page,paramMap.pagesize);
        return JsonResp.Success(goodsListDto);
    }

}
