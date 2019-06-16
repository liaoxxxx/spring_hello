package com.liaoxx.spring_hello.controller.index;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/express")
public class ExpressController {

    @RequestMapping("/query")
    public String query( HttpServletRequest request){
       if( request.getMethod().equals("POST")){
           System.out.println(  request.getParameter("expressNo"));
       }
        return "./index/express/query";

    }
}
