package com.liaoxx.spring_hello.service;
import com.liaoxx.spring_hello.dto.admin.GoodsCategoryDto;
import com.liaoxx.spring_hello.repository.GoodsCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsCategoryService {

    @Autowired
    GoodsCategoryRepository goodsCategoryRepository;


    public void AddGoodsCategory(GoodsCategoryDto goodsCategoryDto){

    }
}
