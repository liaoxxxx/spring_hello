package com.liaoxx.spring_hello.service;

import com.liaoxx.spring_hello.config.AppConfig;
import com.liaoxx.spring_hello.entity.UploadFile;
import com.liaoxx.spring_hello.repository.UploadFileRepository;
import com.liaoxx.spring_hello.util.SqlTimeTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
public class UploadServer {

    @Autowired
    UploadFileRepository uploadFileRepository;

    @Autowired       //使用@AutoWired  自动注入到该类中
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
        String suffixName=fileName.substring(fileName.lastIndexOf("."));
        String prefixPath= appConfig.getUploadImagePath();
        File serviceFile =new File(prefixPath,System.currentTimeMillis()+suffixName);
        //父级目录不存在
        if (!serviceFile.getParentFile().exists()) {
            //创建目录
            serviceFile.getParentFile().mkdirs();
        }
        try {
            // 保存文件
            uploadImage.transferTo(serviceFile);
            //保存到数据库
            UploadFile uploadFile=new UploadFile();
            uploadFile.setPath(serviceFile.getAbsolutePath());
            uploadFile.setCreatedAt(SqlTimeTool.getMicroTimeTamp());
            uploadFile.setUpdatedAt(SqlTimeTool.getMicroTimeTamp());
            uploadFileRepository.save(uploadFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("msg","file upload success");
        map.put("status",1);
        map.put("path",serviceFile.getAbsolutePath());
        return map;


    }
}
