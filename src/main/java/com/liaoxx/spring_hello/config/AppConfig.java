package com.liaoxx.spring_hello.config;

import com.liaoxx.spring_hello.component.OsComponent;
import com.liaoxx.spring_hello.util.DateTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {


    @Value("${server.port}")
    private static int port;




    @Value("${fileUpload.linux.imagePath}")
    private static String UploadImagePathLinux;


    @Value("${fileUpload.windows.imagePath}")
    private static String UploadImagePathWindows;





    //根据系统类型返回文件上传目录
    public static String getUploadImagePath( ){
        String basePath="";
        if (OsComponent.getOsName().equals("linux")){
            basePath= getUploadImagePathLinux();

        }
        else {
            basePath =  getUploadImagePathWindows()+ DateTool.getFormatStr("YYYYMM")+"\\"+DateTool.getFormatStr("dd")+"\\";
        }
        System.out.println(getPort());
        return basePath;
    }


    private static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        AppConfig.port = port;
    }

    private static String getUploadImagePathLinux() {
        return UploadImagePathLinux;
    }

    public static void setUploadImagePathLinux(String uploadImagePathLinux) {
        UploadImagePathLinux = uploadImagePathLinux;
    }

    private static String getUploadImagePathWindows() {
        return UploadImagePathWindows;
    }

    public static void setUploadImagePathWindows(String uploadImagePathWindows) {
        UploadImagePathWindows = uploadImagePathWindows;
    }





}
