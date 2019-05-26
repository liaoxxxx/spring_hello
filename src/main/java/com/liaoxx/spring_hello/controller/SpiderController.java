package com.liaoxx.spring_hello.controller;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.io.IOException;

@Controller
@ResponseBody
@RequestMapping("/spider")
public class SpiderController {
    @RequestMapping("/query")
    public Object query(){
        CloseableHttpClient hc= HttpClients.createDefault();
        HttpGet get=new HttpGet("https://www.bilibili.com/index/recommend.json");
        try {
            CloseableHttpResponse response=hc.execute(get);
            HttpEntity entity =response.getEntity();
            String string = EntityUtils.toString(entity, "utf-8");
            System.out.println(string);
            response.close();
            hc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  0;
    }
}
