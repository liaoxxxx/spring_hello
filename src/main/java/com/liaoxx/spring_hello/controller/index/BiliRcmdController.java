package com.liaoxx.spring_hello.controller.index;

import com.liaoxx.spring_hello.entity.spider.BiliRecommendEntity;
import com.liaoxx.spring_hello.service.BilirecomendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping("/bilircmd")
public class BiliRcmdController {

    @Autowired
    BilirecomendService bilirecomendService;

    @GetMapping("/getone/{id}")
    public void redisTest(@PathVariable("id")Integer  id){

        BiliRecommendEntity biliRecommendEntity= bilirecomendService.getBiliRcmdById(id);

        //System.out.println(biliRecommendEntity);


        System.out.println("fooooo");
        //return biliRecommendEntity;
    }
}
