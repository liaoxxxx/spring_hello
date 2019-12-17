package com.liaoxx.spring_hello.controller.index;


import com.liaoxx.spring_hello.config.AppConfig;
import com.liaoxx.spring_hello.service.UploadServer;
import com.liaoxx.spring_hello.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    UploadServer uploadServer;


    @ResponseBody
    @CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
    @RequestMapping( "/singleImage")
    public Map<String, Object> uploadThumb(@RequestParam(value = "file") MultipartFile file) throws IOException, NoSuchAlgorithmException {
        Map map=uploadServer.handleSingleImage(file);

        return JsonResponse.Success("file uploaded success",map);
    }


}
