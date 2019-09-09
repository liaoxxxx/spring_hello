package com.liaoxx.spring_hello.service;

import com.liaoxx.spring_hello.entity.spider.BiliRecommendEntity;
import com.liaoxx.spring_hello.repository.BiliRecommendVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BilirecomendService {
    @Autowired
    BiliRecommendVideoRepository biliRecommendVideoRepository;

    @Cacheable(cacheNames = "BiliRecommend",key="#id")
    public BiliRecommendEntity getBiliRcmdById(int id){
        return biliRecommendVideoRepository.getOne(id);
    }
}
