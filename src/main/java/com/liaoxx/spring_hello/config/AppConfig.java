package com.liaoxx.spring_hello.config;

import com.liaoxx.spring_hello.component.OsComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {


    @Value("${server.port}")
    private  int port;


    public int getPort() {
        return this.port;
    }




    @Value("${fileUpload.linux.imagePath}")
    private  String UploadImagePathLinux;


    @Value("${fileUpload.windows.imagePath}")
    private  String UploadImagePathWindows;



    //根据系统类型返回文件上传目录
    public String getUploadImagePath( ){
        if (OsComponent.getOsName().equals("linux")){
            return UploadImagePathLinux;
        }
        return UploadImagePathWindows;
    }


}
