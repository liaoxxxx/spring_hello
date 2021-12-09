package com.liaoxx.spring_hello.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liaoxx.spring_hello.constants.SystemEnum;
import com.liaoxx.spring_hello.entity.system.SystemConfig;
import com.liaoxx.spring_hello.entity.system.SystemShopConfig;
import com.liaoxx.spring_hello.repository.SystemRepository;
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
     *  系统商城配置项的键名
     */
    private final String systemShopConfigKey = SystemEnum.SYSTEM_SHOP_CONFIG;


    public SystemShopConfig getSystemShopConfig() {
       // SystemShopConfig shopConfig = (SystemShopConfig) redisCache.get(systemShopConfigKey);
        SystemShopConfig shopConfig=new SystemShopConfig();
        //if (shopConfig == null) {
            shopConfig = getDbSystemShopConfig();
            //同时设置到缓存
            //redisCache.longSet(systemShopConfigKey, shopConfig);
       // }
        return shopConfig;
    }


    public boolean setSystemShopConfig(SystemShopConfig config) {
        //删除
        boolean res = setDbSystemShopConfig(config);
        boolean deleteRes = redisCache.deleteObject(systemShopConfigKey);
        return res;
    }


    public SystemShopConfig getDbSystemShopConfig() {
        SystemShopConfig config =new SystemShopConfig();
        String strConfig = systemRepository.findFirstByKey(systemShopConfigKey).getContent();
        System.out.println("-----------------------------");
        System.out.println(strConfig);
        config=  JSON.parseObject(strConfig,SystemShopConfig.class);
        System.out.println(config.getIsRenlian());
        System.out.println(config.getCDomain());
        System.out.println(config.getIsZgbury());
        return  config;
    }

    public boolean setDbSystemShopConfig(SystemShopConfig config) {
        SystemConfig systemCfg = systemRepository.findFirstByKey(systemShopConfigKey);
        if (systemCfg == null) {
            systemCfg = new SystemConfig();
            systemCfg.setKey(systemShopConfigKey);
        }
        systemCfg.setContent(JSON.toJSONString(config));
        systemRepository.save(systemCfg);
        return true;
    }

}
