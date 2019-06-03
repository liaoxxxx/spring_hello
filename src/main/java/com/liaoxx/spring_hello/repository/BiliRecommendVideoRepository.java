package com.liaoxx.spring_hello.repository;

import com.liaoxx.spring_hello.entity.spider.BiliRecommendEnityt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface BiliRecommendVideoRepository extends JpaRepository<BiliRecommendEnityt,Integer> {

}
