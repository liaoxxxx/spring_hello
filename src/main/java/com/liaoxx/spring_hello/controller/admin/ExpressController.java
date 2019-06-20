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
    public String add_expressprovider(Map map ,HttpServletRequest request){
       if( request.getMethod().equals("POST")){
           ExpressProvider expressProvider=new ExpressProvider();
           expressProvider.setExpressProviderName(request.getParameter("expressName"));
           expressProvider.setExpressProviderChar(request.getParameter("expressCode"));
           expressProvider.setExpressProviderCode(request.getParameter("expressChar"));
           expressProvider.setExpressProviderCode(request.getParameter("expressChar"));
           expressProvider.setRemark(request.getParameter("remark"));
           expressProvider.setCreated_at(System.currentTimeMillis());
           expressProvider.setUpdated_at(System.currentTimeMillis());
           expressProvider.setStatus((byte) 1);
           expressProvider.setIs_delete((byte) 0);
           expressProviderRepository.saveAndFlush(expressProvider);
       }

        //map.put("admin",admin);
        return "./admin/express/add_provider";
    }
}
