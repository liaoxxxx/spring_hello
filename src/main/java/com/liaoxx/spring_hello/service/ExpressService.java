package com.liaoxx.spring_hello.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.liaoxx.spring_hello.config.ExpressConfig;
import com.liaoxx.spring_hello.entity.ExpressCache;
import com.liaoxx.spring_hello.entity.ExpressProvider;
import com.liaoxx.spring_hello.repository.ExpressCacheRepository;
import com.liaoxx.spring_hello.repository.ExpressProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpressService {

    @Autowired
    ExpressProviderRepository expressProviderRepository;

    public   void    saveCache(String expressNo, ExpressProvider expressProvider,String trace,ExpressCacheRepository expressCacheRepository){
        ExpressCache expressCacheEN=new ExpressCache();
        //构建expressCache 实体
        expressCacheEN.setCreated_at( System.currentTimeMillis());
        expressCacheEN.setDatas(trace);
        expressCacheEN.setExpireAt( System.currentTimeMillis()+ExpressConfig.cacheExpireTime);
        expressCacheEN.setExpressProviderCode(expressProvider.getExpressProviderCode());

        expressCacheEN.setExpressProviderName(expressProvider.getExpressProviderName());
        expressCacheEN.setUpdated_at( System.currentTimeMillis());
        expressCacheEN.setExpressNo(expressNo);

        expressCacheRepository.save(expressCacheEN);
   }
   public List decodeTrace(String trace){
       Map respMap= JSON.parseObject(trace); //转为map
       List traceListJson= (JSONArray)respMap.get("Traces"); //获得trace
       List <Map <String,String>> traceList =new ArrayList<>();//存放抽取获得的 轨迹步骤 后的数组
       for (Object object : traceListJson ){
           Map <String,String> traceStepMap=(Map <String,String>) object;
           //System.out.println(traceStepMap.get("AcceptStation"));
           //System.out.println(traceStepMap.get("AcceptTime"));
           traceList.add(traceStepMap);
       }
       return traceList;
    }
}
