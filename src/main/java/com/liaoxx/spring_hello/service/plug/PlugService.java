package com.liaoxx.spring_hello.service.plug;


import com.liaoxx.spring_hello.entity.plug.Plug;
import com.liaoxx.spring_hello.repository.plug.PlugRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.annotation.Repeatable;

/**
 *
 *
 */
@Service
public class PlugService {

    @Resource
    PlugRepository plugRepository;

    public Plug getByKey(String key){
      return   plugRepository.findFirstByKeyOrderByIdDesc(key);
    }

}
