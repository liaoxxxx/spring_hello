package com.liaoxx.spring_hello.component;

import org.springframework.stereotype.Component;

@Component
public class OsComponent {

    public static String getOsName() {
       String os=  System.getProperty("os.name").toLowerCase().substring(0,4);
       System.out.println(os);
       if (os.equals("linux")){
           return "linux";
       }
       return "windows";
    }



}
