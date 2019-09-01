package com.liaoxx.spring_hello.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mobile")
public class OrderController {
    @RequestMapping("/")
    public String list(){
        return  "/mobile/index";
    }
}
