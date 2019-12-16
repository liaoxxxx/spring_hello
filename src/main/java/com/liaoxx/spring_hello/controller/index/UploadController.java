package com.liaoxx.spring_hello.controller.index;


import com.liaoxx.spring_hello.config.AppConfig;
import com.liaoxx.spring_hello.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${spring.fileUpload.windows.imagePath}")
    private String path;


    @Autowired       //使用@AutoWired  自动注入到该类中
    AppConfig appConfig;

    @ResponseBody
    @CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
    @RequestMapping( "/singleImage")
    public Map<String, Object> uploadThumb(@RequestParam(value = "file") MultipartFile file) throws IOException, NoSuchAlgorithmException {
        if(file.isEmpty()){
            return JsonResponse.Error("file is empty","error");
        }
        Map<String,Object> map =new HashMap<>();
        String fileName=file.getOriginalFilename();
        assert fileName != null;
        String suffixName=fileName.substring(fileName.lastIndexOf("."));
        String prefixPath= appConfig.getUploadImagePath();
        File serviceFile =new File(prefixPath,System.currentTimeMillis()+suffixName);

        System.out.println("这是UploadController的:"+path);
        file.transferTo(serviceFile);
        System.out.println(serviceFile.getAbsolutePath());
        map.put("imagePath",serviceFile.getAbsolutePath());

        return JsonResponse.Success("file uploaded success",map);
    }


}
