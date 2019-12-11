package com.liaoxx.spring_hello.util;


import org.apache.commons.codec.digest.DigestUtils;

public class Md5Tool {

    //加密字符串
    public static String getMD5(String string)  {
        return  DigestUtils.md5Hex(string);
    }
}
