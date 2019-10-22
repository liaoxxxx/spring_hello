package com.liaoxx.spring_hello.service;


import com.liaoxx.spring_hello.dto.index.DtoinputDto;
import com.liaoxx.spring_hello.entity.Dto;
import com.liaoxx.spring_hello.repository.DtoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtoService {


    @Autowired
    DtoRepository dtoRepository;

    public Dto transDto2Entity(DtoinputDto dtoinputDto){
        Dto dto =  new Dto();
        BeanUtils.copyProperties(dtoinputDto,dto);
        return dto;
    }


    public void save(Dto dtoEntity){
        dtoRepository.save(dtoEntity);
    }
}
