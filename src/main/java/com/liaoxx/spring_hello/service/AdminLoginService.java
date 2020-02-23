package com.liaoxx.spring_hello.service;

import com.liaoxx.spring_hello.entity.Admin;
import com.liaoxx.spring_hello.entity.Role;
import com.liaoxx.spring_hello.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminLoginService {
    @Autowired
    AdminRepository adminRepository;

    public Admin findByUsername(String userName){
        return adminRepository.findByUsername(userName);
    }

}
