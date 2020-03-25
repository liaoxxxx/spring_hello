package com.liaoxx.spring_hello.util;

import org.springframework.stereotype.Component;

@Component
public class CheckUtil {
    public static boolean isNull(Object obj){
        return null == obj;
    }


}
