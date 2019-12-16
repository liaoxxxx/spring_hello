package com.liaoxx.spring_hello.config;

import com.liaoxx.spring_hello.util.OsComponent;
import com.liaoxx.spring_hello.util.DateTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
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
            basePath =  UploadImagePathWindows+ DateTool.getFormatStr("YYYYMM")+"\\"+DateTool.getFormatStr("dd")+"\\";
        }
        basePath +=DateTool.getFormatStr("YYYYMM")+"\\"+DateTool.getFormatStr("dd")+"\\";
        System.out.println(UploadImagePathLinux);
        System.out.println(UploadImagePathWindows);
        System.out.println(port);
        System.out.println(basePath);
        return basePath;
    }









}
