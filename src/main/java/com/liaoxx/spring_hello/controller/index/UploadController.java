package com.liaoxx.spring_hello.controller.index;


import com.liaoxx.spring_hello.config.Const;
import com.liaoxx.spring_hello.util.JsonResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/upload")
public class UploadController {


    @ResponseBody
    @CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
    @RequestMapping( "/singleImage")
    public Map<String, Object> uploadThumb(@RequestParam(value = "file") MultipartFile file) throws IOException {
        System.out.println((new Const()).getPort());
        Map<String,Object> map =new HashMap<>();

        if(file.isEmpty()){
            return JsonResponse.Error("file is empty","error");
        }
        String fileName=file.getOriginalFilename();

        assert fileName != null;
        String suffixName=fileName.substring(fileName.lastIndexOf("."));

        File serviceFile =new File("D:\\coding\\spring_hello\\src\\main\\resources\\static",fileName);

        file.transferTo(serviceFile);






        return JsonResponse.Success("file uploaded success","success");
    }


}
