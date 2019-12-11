package com.liaoxx.spring_hello.controller.index;


//import com.liaoxx.spring_hello.config.Const;
import com.liaoxx.spring_hello.component.OsComponent;
import com.liaoxx.spring_hello.config.AppConfig;
import com.liaoxx.spring_hello.util.DateTool;
import com.liaoxx.spring_hello.util.JsonResponse;
import com.liaoxx.spring_hello.util.Md5Tool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
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

    @Value("${server.port}")
    private  int port;

    @Value("${fileUpload.windows.imagePath}")
    private  String imagePath;


    private String getImagePath() {
        return this.imagePath;
    }

    private int getPort() {
        return this.port;
    }

    @ResponseBody
    @CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
    @RequestMapping( "/singleImage")
    public Map<String, Object> uploadThumb(@RequestParam(value = "file") MultipartFile file) throws IOException, NoSuchAlgorithmException {
        System.out.println(Md5Tool.getMD5("aaa"));
        if(file.isEmpty()){
            return JsonResponse.Error("file is empty","error");
        }
        Map<String,Object> map =new HashMap<>();
        String fileName=file.getOriginalFilename();

        assert fileName != null;
        String suffixName=fileName.substring(fileName.lastIndexOf("."));
        String prefixPath= AppConfig.getUploadImagePath();
        String suffixPath= DateTool.getFormatStr("YYYYMM");
        System.out.println(suffixPath);


        File serviceFile =new File(prefixPath,fileName);

        file.transferTo(serviceFile);
        System.out.println(serviceFile.getAbsolutePath());
        map.put("imagePath",serviceFile.getAbsolutePath());




        return JsonResponse.Success("file uploaded success",map);
    }


}
