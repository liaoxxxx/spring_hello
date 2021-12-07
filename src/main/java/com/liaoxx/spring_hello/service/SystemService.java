package com.liaoxx.spring_hello.service;

import com.alibaba.fastjson.JSONObject;
import com.liaoxx.spring_hello.component.Audience;
import com.liaoxx.spring_hello.constants.LoginType;
import com.liaoxx.spring_hello.constants.MainState;
import com.liaoxx.spring_hello.constants.SystemEnum;
import com.liaoxx.spring_hello.dto.api.common.MallConfigDto;
import com.liaoxx.spring_hello.dto.api.user.LoginDto;
import com.liaoxx.spring_hello.entity.User;
import com.liaoxx.spring_hello.entity.system.System;
import com.liaoxx.spring_hello.entity.system.SystemShopConfig;
import com.liaoxx.spring_hello.param.api.user.LoginParam;
import com.liaoxx.spring_hello.repository.SystemRepository;
import com.liaoxx.spring_hello.repository.UserRepository;
import com.liaoxx.spring_hello.service.exception.ServiceException;
import com.liaoxx.spring_hello.util.JwtTokenUtil;
import com.liaoxx.spring_hello.util.Md5Tool;
import com.liaoxx.spring_hello.util.RedisCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class SystemService {
    @Resource
    SystemRepository systemRepository;

    @Resource
    RedisCache redisCache;

    /**
     *
     */
    private final String  systemShopConfigKey=SystemEnum.SYSTEM_SHOP_CONFIG;




    public SystemShopConfig getSystemShopConfig(){

        SystemShopConfig shopConfig=  redisCache.get(systemShopConfigKey);
        if (shopConfig==null){
            shopConfig=   getDbSystemShopConfig();
        }
        return shopConfig;
    }


    public SystemShopConfig setSystemShopConfig(){
        String key= SystemEnum.SYSTEM_SHOP_CONFIG;
        SystemShopConfig shopConfig=  redisCache.get(key);
        if (shopConfig==null){
            redisCache.longSet()
        }
        return shopConfig;
    }



    public SystemShopConfig getDbSystemShopConfig(){
       String strConfig=  systemRepository.findFirstByKey(systemShopConfigKey).getContent();
        SystemShopConfig shopConfig = (SystemShopConfig) JSONObject.parse(strConfig);
        redisCache.longSet(systemShopConfigKey,shopConfig);
        return shopConfig;
    }

    public SystemShopConfig setDbSystemShopConfig(){
        String key= SystemEnum.SYSTEM_SHOP_CONFIG;
        SystemShopConfig shopConfig=  redisCache.get(key);
        if (shopConfig==null){
            redisCache.longSet();
        }
        return shopConfig;
    }

}
