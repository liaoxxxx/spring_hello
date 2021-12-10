package com.liaoxx.spring_hello.util.request;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * http请求工具
 * </p>
 *
 * @author liaoxx
 * @since 2021-12-10
 */
public class HttpRequestUtil {

    /**
     * @param request http请求实例
     * @param headerKey 要获取的请求头的值
     * @return         获取到的请求头的值  默认为 ""
     * */
    public static String getHeader(HttpServletRequest request, String headerKey) {
        String headerValue = request.getHeader(headerKey);
        if (headerValue != null) {
            return headerValue;
        }
        return "";
    }
}
