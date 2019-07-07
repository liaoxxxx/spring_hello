package com.liaoxx.spring_hello.controller.index;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liaoxx.spring_hello.config.ExpressConfig;
import com.liaoxx.spring_hello.entity.ExpressCache;
import com.liaoxx.spring_hello.entity.ExpressProvider;
import com.liaoxx.spring_hello.repository.ExpressCacheRepository;
import com.liaoxx.spring_hello.repository.ExpressProviderRepository;
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
           if (expressCache==null){
                try {
                    KdniaoTrackQueryAPI kdnAPI=  new KdniaoTrackQueryAPI();
                    String trace =kdnAPI.getOrderTracesByJson(expressOne.getExpressProviderCode(),expressNo,expressOne.getExpressProviderCustomerName());
                    ExpressCache expressCacheEN=new ExpressCache();
                    //构建expressCache 实体
                    expressCacheEN.setCreated_at( System.currentTimeMillis());
                    expressCacheEN.setExpireAt( System.currentTimeMillis()+ExpressConfig.cacheExpireTime);
                    expressCacheEN.setExpressNo(expressNo);
                    expressCacheEN.setExpressProviderCode(expressOne.getExpressProviderCode());
                    expressCacheEN.setExpressProviderName(expressOne.getExpressProviderName());
                    expressCacheEN.setDatas(trace);
                    expressCacheEN.setUpdated_at( System.currentTimeMillis());
                    expressCacheRepository.saveAndFlush(expressCacheEN);
                    Map respMap= JSON.parseObject(trace); //转为map
                    List traceListJson= (JSONArray)respMap.get("Traces"); //获得trace
                    List <Map <String,String>> traceList =new ArrayList<>();//存放抽取获得的 轨迹步骤 后的数组
                    for (Object object : traceListJson ){
                        Map <String,String> traceStepMap=(Map <String,String>) object;
                        System.out.println(traceStepMap.get("AcceptStation"));
                        System.out.println(traceStepMap.get("AcceptTime"));
                        traceList.add(traceStepMap);
                    }
                    map.put("traceListHtml",traceList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
