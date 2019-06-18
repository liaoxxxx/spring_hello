package com.liaoxx.spring_hello.controller.index;


import com.liaoxx.spring_hello.service.KdniaoTrackQueryAPI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/express")
public class ExpressController {

    @RequestMapping("/query")
    public String query( HttpServletRequest request){
       if( request.getMethod().equals("POST")){
          String expressNo=  request.getParameter("expressNo");
           System.out.println(expressNo);
           KdniaoTrackQueryAPI kdn=  new KdniaoTrackQueryAPI();
           System.out.println( kdn.getClass());
       }
        return "./index/express/query";

    }
}
