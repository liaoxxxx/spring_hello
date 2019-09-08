package com.liaoxx.spring_hello.repository;

import com.liaoxx.spring_hello.entity.spider.BiliRecommendEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiliRecommendVideoRepository extends JpaRepository<BiliRecommendEntity,Integer> {


}
