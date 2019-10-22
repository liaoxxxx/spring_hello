package com.liaoxx.spring_hello.controller.index;


import com.liaoxx.spring_hello.dto.index.DtoinputDto;
import com.liaoxx.spring_hello.entity.Dto;
import com.liaoxx.spring_hello.repository.BiliRecommendVideoRepository;
import com.liaoxx.spring_hello.repository.DtoRepository;
import com.liaoxx.spring_hello.service.DtoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
@RequestMapping("/dto")
public class DtotestController {

    @Autowired
    DtoService dtoService;




    @RequestMapping("/test")
    @ResponseBody
    public String test(DtoinputDto dtoinputDto) {
        System.out.println(dtoinputDto.getUsername());
        System.out.println(dtoinputDto.getPassword());
        System.out.println(dtoinputDto.getSalt());

        Dto dtoEntity=dtoService.transDto2Entity(dtoinputDto);


        System.out.println("******************copyProperties()后**********************");
        System.out.println(dtoEntity.getUsername());
        System.out.println(dtoEntity.getPassword());
        System.out.println(dtoEntity.getSalt());
        System.out.println(dtoEntity.getCreatTime());

        dtoService.save(dtoEntity);

        return dtoinputDto.getUsername();
    }


}
