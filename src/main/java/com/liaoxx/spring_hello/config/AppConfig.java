package com.liaoxx.spring_hello.config;

import com.liaoxx.spring_hello.util.OsComponent;
import com.liaoxx.spring_hello.util.DateTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component    // 在配置类注解为@Component 类
public class AppConfig {


    @Value("${server.port}")
    private  int port;

   private String  UploadImagePrefixUrl="\\image";


    @Value("${spring.fileUpload.linux.imagePath}")
    private  String UploadImagePathLinux;


    @Value("${spring.fileUpload.windows.imagePath}")
    private  String UploadImagePathWindows;

    public String getUploadImagePathLinux() {
        return UploadImagePathLinux;
    }

    public String getUploadImagePathWindows() {
        return UploadImagePathWindows;
    }

    //根据系统类型返回文件基础上传目录
    public String getUploadImagePath(){
        String basePath="";
        if (OsComponent.getOsName().equals("linux")){
          return   basePath=UploadImagePathLinux;
        }
        else if (OsComponent.getOsName().equals("windows")){
            return   basePath =  UploadImagePathWindows;
        }

       return "";
    }

    //根据系统类型返回文件基础上传目录
    public String  getDatePath(){
       return "\\"+DateTool.getFormatStr("YYYYMM")+"\\"+DateTool.getFormatStr("dd")+"\\";
    }

    //
    public String getImageUploadPrefixUrl(){
        return UploadImagePrefixUrl;
    }









}
