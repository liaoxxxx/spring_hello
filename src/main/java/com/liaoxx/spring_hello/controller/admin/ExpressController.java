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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;


//@RestController //注解无法返回视图，默认返回JSON数据。
@Controller
@RequestMapping("/admin")
public class ExpressController {

    @Autowired
    ExpressProviderRepository expressProviderRepository;
    @RequestMapping("/add_expressprovider")
    public String add_expressprovider(HttpServletRequest request,
                                      @RequestParam (value = "expressCustomer",required = false)String expressCustomer,
                                      @RequestParam (value = "expressCode",required = false)String expressCode,
                                      @RequestParam (value = "expressChar",required = false)String expressChar,
                                      @RequestParam (value = "expressName",required = false)String expressName,
                                      @RequestParam (value = "remark",required = false)String remark
    ){
       if( request.getMethod().equals("POST")){
           ExpressProvider expressProvider=new ExpressProvider();
           expressProvider.setExpressProviderName(expressName);
           expressProvider.setExpressProviderChar(expressChar);
           expressProvider.setExpressProviderCode(expressCode);
           expressProvider.setExpressProviderCustomerName(expressCustomer);
           expressProvider.setRemark(remark);
           expressProvider.setCreated_at(System.currentTimeMillis());
           expressProvider.setUpdated_at(System.currentTimeMillis());
           expressProvider.setStatus((byte) 1);
           expressProvider.setIs_delete((byte) 0);
           expressProviderRepository.saveAndFlush(expressProvider);
       }
        return "./admin/express/add_provider";
    }
}
