package com.liaoxx.spring_hello.util;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class Base64Util {
    public  String encode(String string) throws UnsupportedEncodingException {

        // 使用基本编码
        return Base64.getEncoder().encodeToString(string.getBytes(StandardCharsets.UTF_8));
    }
    public  String decode(String token) throws UnsupportedEncodingException {

        // 使用基本编码
        return new String(Base64.getDecoder().decode(token), "utf-8");
    }
}
