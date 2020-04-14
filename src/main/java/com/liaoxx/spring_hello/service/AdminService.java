package com.liaoxx.spring_hello.service;

import com.liaoxx.spring_hello.dto.admin.AdminDto;
import com.liaoxx.spring_hello.entity.Admin;
import com.liaoxx.spring_hello.mapper.AdminMapper;
import com.liaoxx.spring_hello.model.AdminModel;
import com.liaoxx.spring_hello.repository.AdminRepository;
import com.liaoxx.spring_hello.util.JsonResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public AdminDto getAdminDtoById(int id){
        AdminModel admin= adminMapper.getById(id);
        AdminDto adminDto=new AdminDto();
        BeanUtils.copyProperties(admin,adminDto);
        return adminDto;
    }

    public Map<String, Object> edit(AdminDto adminDto){

        AdminModel adminModel=adminMapper.getById(adminDto.getId());
        if (adminModel==null){
            return JsonResponse.Error("未提交管理员的id",adminDto);
        }
        BeanUtils.copyProperties(  adminDto,adminModel);
        // System.out.println(adminModel.toString());
        boolean updtBool= adminMapper.Update(adminModel);
        if (updtBool){
            return JsonResponse.Success("管理员"+adminDto.getId()+"修改成功",adminDto);
        }
        return  JsonResponse.Error("未知的错误",adminDto);
    }

}
