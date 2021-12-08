package com.liaoxx.spring_hello.service;

import com.liaoxx.spring_hello.dto.api.common.MallConfigDto;
import com.liaoxx.spring_hello.entity.system.SystemShopConfig;
import com.liaoxx.spring_hello.repository.SystemRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommonService {
    @Resource
    SystemService systemService;




    public MallConfigDto commonConfig() {
        MallConfigDto mallConfigDto=  new MallConfigDto();
        mallConfigDto.system=systemService.getSystemShopConfig();
        return mallConfigDto;
    }




}
