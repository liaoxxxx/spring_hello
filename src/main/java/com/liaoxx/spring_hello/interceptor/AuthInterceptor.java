package com.liaoxx.spring_hello.interceptor;

import org.springframework.lang.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull Object handler) throws Exception {
        System.out.println("preHandle,ok,假设给你一个true，运行去吧");
        request.setAttribute("user-name","liaoxxx");
        return true;
    }
    @Override
    public void postHandle(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle,ok,看看我什么时候运行的。");
    }
    @Override
    public void afterCompletion(HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion,ok,看完不点个赞再走吗？");
        System.out.println(request.getAttribute("user-name"));
    }
}
