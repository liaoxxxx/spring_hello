package com.liaoxx.spring_hello.config;


import com.liaoxx.spring_hello.interceptor.JwtAuthenticationInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

public class JwtInterceptorConfig implements WebMvcConfigurer {
        @Override
        public void addInterceptors(InterceptorRegistry registry) {

            //默认拦截所有路径
            registry.addInterceptor(authenticationInterceptor())
                    .addPathPatterns("/**");
        }
        @Bean
        public JwtAuthenticationInterceptor authenticationInterceptor() {
            return new JwtAuthenticationInterceptor();
        }

}
