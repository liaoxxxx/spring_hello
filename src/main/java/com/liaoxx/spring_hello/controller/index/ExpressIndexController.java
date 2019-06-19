package com.liaoxx.spring_hello.controller.index;


import com.alibaba.fastjson.JSONObject;
import com.liaoxx.spring_hello.service.KdniaoTrackQueryAPI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/express")
public class ExpressIndexController {

    @RequestMapping("/query")
    public String query( HttpServletRequest request){
       if( request.getMethod().equals("POST")){
           String expressNo=  request.getParameter("expressNo");
           String expressCode=request.getParameter("expressCode");
           KdniaoTrackQueryAPI kdnAPI=  new KdniaoTrackQueryAPI();
           // String trace =kdnAPI.getOrderTracesByJson("",expressNo);
       }
        return "./index/express/query";

    }
}
