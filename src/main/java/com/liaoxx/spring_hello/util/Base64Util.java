package com.liaoxx.spring_hello.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Util {
    public static String encode(String string) throws UnsupportedEncodingException {

        // 使用基本编码
        return Base64.getEncoder().encodeToString(string.getBytes(StandardCharsets.UTF_8));
    }
}
