package com.liaoxx.spring_hello.util.response;

import java.net.HttpURLConnection;

public class Error {
    public static  final int success= 1;
    public static  final String successMsg= "请求成功";
    public static  final int innerError= HttpURLConnection.HTTP_INTERNAL_ERROR;
    private static final int notFound= HttpURLConnection.HTTP_NOT_FOUND;

}
