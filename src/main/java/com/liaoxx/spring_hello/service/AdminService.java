package com.liaoxx.spring_hello.service;

import com.liaoxx.spring_hello.dto.admin.AdminAddDto;
import com.liaoxx.spring_hello.dto.admin.AdminDto;
import com.liaoxx.spring_hello.entity.Admin;
import com.liaoxx.spring_hello.mapper.AdminMapper;
import com.liaoxx.spring_hello.model.AdminModel;
import com.liaoxx.spring_hello.repository.AdminRepository;
import com.liaoxx.spring_hello.util.response.JsonResp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    public JsonResp edit(AdminDto adminDto){

        AdminModel adminModel=adminMapper.getById(adminDto.getId());
        if (adminModel==null){
            return JsonResp.Error("未提交管理员的id");
        }
        BeanUtils.copyProperties(  adminDto,adminModel);
        // System.out.println(adminModel.toString());
        boolean updtBool= adminMapper.Update(adminModel);
        if (updtBool){
            return JsonResp.Success(adminDto,"管理员"+adminDto.getId()+"修改成功");
        }
        return  JsonResp.Error("未知的错误");
    }

    public JsonResp add(AdminAddDto adminAddDto){
        //避免用户名重复
        AdminModel adminModel=adminMapper.findByUserName(adminAddDto.getUsername());
        System.out.println(adminAddDto.toString());
        if (adminModel != null){
            return JsonResp.Error("未提交管理员的id");
        }
        assert false;
        AdminModel adminModel1=new AdminModel();
        BeanUtils.copyProperties(  adminAddDto,adminModel1);

        boolean updtBool= adminMapper.install(adminModel1);
        if (updtBool){
            return JsonResp.Success("管理员"+adminAddDto.getUsername()+"添加成功");
        }
        return  JsonResp.Error("未知的错误");
    }


    protected AdminModel buildAdminModel(  AdminAddDto adminAddDto){

        return new AdminModel();
    }

}
