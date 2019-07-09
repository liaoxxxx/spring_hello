package com.liaoxx.spring_hello.controller.index;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liaoxx.spring_hello.config.ExpressConfig;
import com.liaoxx.spring_hello.entity.ExpressCache;
import com.liaoxx.spring_hello.entity.ExpressProvider;
import com.liaoxx.spring_hello.repository.ExpressCacheRepository;
import com.liaoxx.spring_hello.repository.ExpressProviderRepository;
import com.liaoxx.spring_hello.service.ExpressService;
import com.liaoxx.spring_hello.service.KdniaoTrackQueryAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/express")
public class ExpressQueryController {

    @Autowired
    ExpressProviderRepository expressProviderRepository;
    @Autowired
    ExpressCacheRepository expressCacheRepository;
    @RequestMapping("/query")
    public String query(HttpServletRequest request ,
                        @RequestParam (value = "expressNo",required = false)String expressNo,
                        @RequestParam (value = "expressId",required = false,defaultValue = "0") int expressId,
                        Map <String, Object> map){
       if( request.getMethod().equals("POST")){
           //获取快递提供商信息
           ExpressProvider expressOne = expressProviderRepository.getOne(expressId);
           //查询缓存
           ExpressCache expressCache =expressCacheRepository.getByExpressProviderCodeAndExpressNo(expressOne.getExpressProviderCode(),expressNo);
           ExpressService expressService=new ExpressService();
           if (expressCache==null){
                try {

                    //查询
                    KdniaoTrackQueryAPI kdnAPI=  new KdniaoTrackQueryAPI();
                    String trace =kdnAPI.getOrderTracesByJson(expressOne.getExpressProviderCode(),expressNo,expressOne.getExpressProviderCustomerName());
                    //存入
                    expressService.saveCache(expressNo,expressOne,trace,expressCacheRepository);
                    List traceList=expressService.decodeTrace(trace);
                    map.put("traceListHtml",traceList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
           } else{
               List traceList=expressService.decodeTrace(expressCache.getDatas());
               map.put("traceListHtml",traceList);
           }
       }

        List expressList= expressProviderRepository.findAll();
        map.put("expressList",expressList);
        return "./index/express/query";
    }


    @ResponseBody
    @RequestMapping("/findbycode")
    public String findByExpressProviderCode(){
        ExpressProvider expressProvider= expressProviderRepository.findByExpressProviderCode("JD");
        System.out.println(expressProvider);
        //expressProviderRepository.findAll(expressProvider);
        JSONObject jsonObject=new JSONObject();
        String expressString= jsonObject.toJSONString(expressProvider);
        Object expressProvider1=JSONObject.parseObject(expressString);
        System.out.println(expressProvider1);
        return  expressString;
    }
}
