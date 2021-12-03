package com.liaoxx.spring_hello.config;

import com.liaoxx.spring_hello.util.OsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@EnableWebMvc
@ComponentScan
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {



    @Resource
    AppConfig appConfig;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //WINDOWS用
        //WINDOWS用
        if(OsComponent.getOsName()=="windows"){
            registry.addResourceHandler("/image/**").addResourceLocations("file:"+appConfig.getUploadImagePathWindows());
        }
        else {
            //LINUX用
            registry.addResourceHandler("/image/**").addResourceLocations("file:/usr/local/img/");
        }

    }
}
