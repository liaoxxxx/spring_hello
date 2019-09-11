package com.liaoxx.spring_hello.service;

import com.liaoxx.spring_hello.entity.spider.BiliRecommendEntity;
import com.liaoxx.spring_hello.repository.BiliRecommendVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.OneToMany;
import java.util.Map;

@Service
public class BilirecomendService {
    @Autowired
    BiliRecommendVideoRepository biliRecommendVideoRepository;

    @Cacheable(cacheNames = "BiliRecommend",key="#id")
    public BiliRecommendEntity getBiliRcmdById(int id){
        return biliRecommendVideoRepository.getOne(id);
    }


    public void insertBiliRcmd(){

    }
    @CachePut(cacheNames = "BiliRecommend",key = "#id")
    public BiliRecommendEntity updateBilirecmd(int id, Map<String,Object> map){
        BiliRecommendEntity biliRecommendEntity=biliRecommendVideoRepository.getOne(id);

        biliRecommendVideoRepository.save(biliRecommendEntity);
        return biliRecommendEntity;
    }
}
