package com.liaoxx.spring_hello.controller.index;


import com.liaoxx.spring_hello.entity.ExpressCache;
import com.liaoxx.spring_hello.entity.ExpressProvider;
import com.liaoxx.spring_hello.repository.ExpressCacheRepository;
import com.liaoxx.spring_hello.repository.ExpressProviderRepository;
import com.liaoxx.spring_hello.service.ExpressService;
import com.liaoxx.spring_hello.service.KdniaoTrackQueryAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/excel")
public class ExcelController {
    public void write(){
    }

}



