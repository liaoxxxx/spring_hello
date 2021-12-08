package com.liaoxx.spring_hello.util;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class Md5Tool {

    //加密字符串
    public static String get(String string)  {
        return  DigestUtils.md5Hex(string);
    }
}
