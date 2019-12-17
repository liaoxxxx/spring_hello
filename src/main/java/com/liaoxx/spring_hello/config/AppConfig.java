package com.liaoxx.spring_hello.config;

import com.liaoxx.spring_hello.util.OsComponent;
import com.liaoxx.spring_hello.util.DateTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component    // 在配置类注解为@Component 类
public class AppConfig {


    @Value("${server.port}")
    private  int port;




    @Value("${spring.fileUpload.linux.imagePath}")
    private  String UploadImagePathLinux;


    @Value("${spring.fileUpload.windows.imagePath}")
    private  String UploadImagePathWindows;



    //根据系统类型返回文件上传目录
    public String getUploadImagePath(){
        String basePath="";
        if (OsComponent.getOsName().equals("linux")){
            basePath=UploadImagePathLinux;
        }
        else if (OsComponent.getOsName().equals("windows")){
            basePath =  UploadImagePathWindows;
        }
        basePath +=DateTool.getFormatStr("YYYYMM")+"\\"+DateTool.getFormatStr("dd")+"\\";
        return basePath;
    }









}
