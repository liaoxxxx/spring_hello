package com.liaoxx.spring_hello.service;

import com.liaoxx.spring_hello.entity.Admin;
import com.liaoxx.spring_hello.repository.AdminRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class AdminLoginService {
    @Resource
    AdminRepository adminRepository;

    public Admin findByUsername(String userName){
        return adminRepository.findByUsername(userName);
    }

}
