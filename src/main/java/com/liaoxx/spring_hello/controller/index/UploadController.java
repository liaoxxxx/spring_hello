package com.liaoxx.spring_hello.controller.index;


import com.liaoxx.spring_hello.service.UploadServer;
import com.liaoxx.spring_hello.util.response.JsonResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    UploadServer uploadServer;


    @ResponseBody
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping( "/singleImage")
    public JsonResp uploadThumb(@RequestParam(value = "file") MultipartFile file)  {
        Map<String,Object> map=uploadServer.handleSingleImage(file);
        System.out.println(map.get("path"));
        if ((int)map.get("status")==1){
            return JsonResp.Success(map,(String) map.get("msg"));
        }else {
            return JsonResp.Error( (String) map.get("msg"));
        }

    }


}
