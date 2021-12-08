package com.liaoxx.spring_hello.service;

import com.liaoxx.spring_hello.dto.api.common.MallConfigDto;
import com.liaoxx.spring_hello.entity.system.SystemShopConfig;
import com.liaoxx.spring_hello.repository.SystemRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommonService {
    @Resource
    SystemRepository systemRepository;




    public MallConfigDto commonConfig() throws Exception {
        return  new MallConfigDto();
    }




}
