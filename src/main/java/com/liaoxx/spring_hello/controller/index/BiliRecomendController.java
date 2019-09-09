package com.liaoxx.spring_hello.controller.index;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.liaoxx.spring_hello.entity.spider.BiliRecommendEntity;
import com.liaoxx.spring_hello.repository.BiliRecommendVideoRepository;
import com.liaoxx.spring_hello.service.BilirecomendService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/bilircmd")
public class BiliRecomendController {

    @Autowired
    BilirecomendService bilirecomendService;

    @GetMapping("/getone/{id}")
    public void redisTest(@PathVariable("id")Integer  id){

        BiliRecommendEntity biliRecommendEntity= bilirecomendService.getBiliRcmdById(id);

        //System.out.println(biliRecommendEntity.getDescription());

        System.out.println(biliRecommendEntity.getAuthor());
        System.out.println("fooooo");
        //return biliRecommendEntity;
    }
}
