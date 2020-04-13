package com.liaoxx.spring_hello.service;

import com.liaoxx.spring_hello.dto.admin.AdminDto;
import com.liaoxx.spring_hello.entity.Admin;
import com.liaoxx.spring_hello.mapper.AdminMapper;
import com.liaoxx.spring_hello.model.AdminModel;
import com.liaoxx.spring_hello.repository.AdminRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;


    @Autowired
    AdminMapper adminMapper;


    public Admin findByUsername(String userName){
        return adminRepository.findByUsername(userName);
    }

    public List<AdminModel> getAdminByPage(int page, int pageSize) {

        List<AdminModel> adminList = adminMapper.getByPage( "`id`", 0, 20);
        //List<AdminModel> adminList = adminMapper.getByPage(0, 20);
        return adminList;

    }

    public AdminDto getOneById(int id){
        AdminModel admin= adminMapper.getById(id);
        AdminDto adminDto=new AdminDto();
        BeanUtils.copyProperties(admin,adminDto);
        return adminDto;
    }

}
