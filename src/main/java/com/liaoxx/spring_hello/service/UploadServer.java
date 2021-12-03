package com.liaoxx.spring_hello.service;

import com.liaoxx.spring_hello.config.AppConfig;
import com.liaoxx.spring_hello.repository.UploadFileRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class UploadServer {



    @Resource
    UploadFileRepository uploadFileRepository;

    @Resource       //使用@Resource  自动注入到该类中
    AppConfig appConfig;

    public Map<String, Object> handleSingleImage(MultipartFile uploadImage ) {
        Map<String,Object> map =new HashMap<>();
        //空文件
        if(uploadImage.isEmpty()){
            map.put("msg","file is empty");
            map.put("status",0);
            return map;
        }

        String fileName=uploadImage.getOriginalFilename();
        assert fileName != null;
        //文件名  时间戳+随机数+ 后缀名
        String suffixName=System.currentTimeMillis()+(  ( new Random()  ).nextInt(90)+10   )  + fileName.substring(fileName.lastIndexOf("."));
        //上传路径
        String prefixPath= appConfig.getUploadImagePath();
        //所属的日期路径
        String datePath= appConfig.getDatePath();

        File serviceFile =new File(prefixPath+datePath,suffixName);
        //父级目录不存在
        if (!serviceFile.getParentFile().exists()) {
            //创建目录
            serviceFile.getParentFile().mkdirs();
        }
        try {
            // 保存文件
            uploadImage.transferTo(serviceFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("msg","file upload success");
        map.put("status",1);
        map.put("path",appConfig.getImageUploadPrefixUrl()+datePath+suffixName);
        return map;


    }
}
