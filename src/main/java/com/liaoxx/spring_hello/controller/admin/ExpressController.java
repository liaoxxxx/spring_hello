package com.liaoxx.spring_hello.controller.admin;

import com.liaoxx.spring_hello.entity.Admin;
import com.liaoxx.spring_hello.entity.ExpressProvider;
import com.liaoxx.spring_hello.repository.ExpressProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;


//@RestController //注解无法返回视图，默认返回JSON数据。
@Controller
@RequestMapping("/admin")
public class ExpressController {

    @Autowired
    ExpressProviderRepository expressProviderRepository;
    @GetMapping("/add_expressprovider")
    public String findOne(Map map){
        ExpressProvider expressProvider =expressProviderRepository.getOne(1);
        System.out.println(expressProvider);
        //map.put("admin",admin);
        return "./admin/express/add_provider";
    }
}
