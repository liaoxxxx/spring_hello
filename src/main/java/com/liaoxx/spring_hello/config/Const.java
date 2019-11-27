package com.liaoxx.spring_hello.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Const {


    @Value("${server.port}")
    private  int port;


    public int getPort() {
        return this.port;
    }

}
