package com.liaoxx.spring_hello.controller.api.orer;

import com.liaoxx.spring_hello.exception.ServiceException;
import com.liaoxx.spring_hello.export.api.goods.GoodsDetailExport;
import com.liaoxx.spring_hello.export.api.order.freight.Freight;
import com.liaoxx.spring_hello.export.api.order.freight.FreightListExport;
import com.liaoxx.spring_hello.param.api.ApiParamMap;
import com.liaoxx.spring_hello.param.api.goods.GoodsListParam;
import com.liaoxx.spring_hello.service.goods.GoodsService;
import com.liaoxx.spring_hello.util.response.JsonResp;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@CrossOrigin(origins = "*", maxAge = 3600,methods ={RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
@RestController
@RequestMapping("/xx/order/")
public class FreightController {

    @Resource
    GoodsService goodsService;

    @PostMapping(value = "freight/list")
    public JsonResp list(HttpServletRequest request){
        Freight freight=new Freight();
        FreightListExport freightListExport= new FreightListExport();
        freightListExport.list=freight;
        return JsonResp.Success(freightListExport);
    }





}
