package com.liaoxx.spring_hello.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.liaoxx.spring_hello.entity.spider.BiliRecommendEnityt;
import com.liaoxx.spring_hello.repository.BiliRecommendVideoRepository;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.io.IOException;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/spider")
public class SpiderController {
    @Autowired
    BiliRecommendVideoRepository biliRecommendVideoRepository;

    @RequestMapping("/query")
    public Object query(){
        System.out.println("88888888888888888888888888888888888888888888");
        CloseableHttpClient hc= HttpClients.createDefault();
        HttpGet get=new HttpGet("https://www.bilibili.com/index/recommend.json");
        try {
            //new
            CloseableHttpResponse response=hc.execute(get);
            HttpEntity entity =response.getEntity();
            String jsonString = EntityUtils.toString(entity, "utf-8");
            //System.out.println(jsonString);
            //关闭请求
            response.close();
            hc.close();
            //json 解析
            Map map=JSON.parseObject(jsonString); //转为map
            Object listObj =map.get("list");  //取 key => list
            List listParse=(JSONArray) listObj; //转为Litt
            //循环
            for (Object object :listParse){
                Map<String ,Object> map1=(Map) object;
                System.out.println(map1);

                BiliRecommendEnityt biliRecommendEnityt=new BiliRecommendEnityt();

                biliRecommendEnityt.setAid((int)map1.get("aid"));
                biliRecommendEnityt.setPic((String)map1.get("pic"));
                biliRecommendEnityt.setAuthor((String)map1.get("author"));
                biliRecommendEnityt.setDescription((String)map1.get("description"));
                biliRecommendEnityt.setMid((int)map1.get("mid"));
                biliRecommendEnityt.setSubtitle((String)map1.get("subtitle"));
                biliRecommendEnityt.setTitle((String) map1.get("title"));
                biliRecommendEnityt.setTypename((String) map1.get("typename"));

                biliRecommendVideoRepository.saveAndFlush(biliRecommendEnityt);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return  0;
    }
}
