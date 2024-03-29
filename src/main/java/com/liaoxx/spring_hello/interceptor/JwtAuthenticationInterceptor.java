package com.liaoxx.spring_hello.interceptor;


import com.liaoxx.spring_hello.annotation.PassToken;
import com.liaoxx.spring_hello.entity.user.UserDto;
import com.liaoxx.spring_hello.exception.AuthException;
import com.liaoxx.spring_hello.service.user.UserService;
import com.liaoxx.spring_hello.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author Lehr
 * @create: 2020-02-03
 */
public class JwtAuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从请求头中取出 token  这里需要和前端约定好把jwt放到请求头一个叫token的地方
        String token = httpServletRequest.getHeader("token");
        String userType ="user";
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        System.out.println("被jwt拦截需要验证");
        // 执行认证
        if (token == null) {
            //这里其实是登录失效,没token了   这个错误也是我自定义的，读者需要自己修改
            throw new AuthException("登录失效,token(Header)获取失败");
        }

        // 获取 token 中的 user Name
        Map<String, Object> payload = JwtTokenUtil.getPayload(token);
        int userId = (int) payload.get("");
        //找找看是否有这个user   因为我们需要检查用户是否存在，读者可以自行修改逻辑
        UserDto user = userService.find(userId);



        //放入attribute以便后面调用
        httpServletRequest.setAttribute("userType", userType);
        httpServletRequest.setAttribute("userId", user.id);

        httpServletRequest.getAttributeNames();

        return true;


    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }

}
