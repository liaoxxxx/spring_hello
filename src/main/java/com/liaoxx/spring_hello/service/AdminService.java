package com.liaoxx.spring_hello.service;

import com.liaoxx.spring_hello.dto.admin.AdminAddDto;
import com.liaoxx.spring_hello.dto.admin.AdminDto;
import com.liaoxx.spring_hello.entity.Admin;
import com.liaoxx.spring_hello.repository.AdminRepository;
import com.liaoxx.spring_hello.util.response.JsonResp;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {
   


    @Resource
    AdminRepository adminRepository;


    public Admin findByUsername(String userName){
        return adminRepository.findByUsername(userName);
    }

    public List<Admin> getAdminByPage(int page, int pageSize) {
        Sort sort =  Sort.by(Sort.Direction.DESC, "id");  // 这里的"recordNo"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
        Pageable pageable = new PageRequest(page - 1, pageSize, sort) {
        }; // （当前页， 每页记录数， 排序方式）
       // List<Admin> adminList = adminRepository.findall( pageable);
        List<Admin> adminList = adminRepository.findAll();
        //List<Admin> adminList = adminRepository.getByPage(0, 20);
        return adminList;
    }

    public AdminDto getAdminDtoById(int id){
        Admin admin= adminRepository.getById(id);
        AdminDto adminDto=new AdminDto();
        BeanUtils.copyProperties(admin,adminDto);
        return adminDto;
    }

    public JsonResp edit(AdminDto adminDto){

        Admin Admin=adminRepository.getById((int) adminDto.getId());
        if (Admin==null){
            return JsonResp.Error("未提交管理员的id");
        }
        BeanUtils.copyProperties(  adminDto,Admin);
        // System.out.println(Admin.toString());
         Admin= adminRepository.save(Admin);
        if (Admin.getId()>0){
            return JsonResp.Success(adminDto,"管理员"+adminDto.getId()+"修改成功");
        }
        return  JsonResp.Error("未知的错误");
    }

    public JsonResp add(AdminAddDto adminAddDto){
        //避免用户名重复
        Admin Admin=adminRepository.findByUsername(adminAddDto.getUsername());
        System.out.println(adminAddDto.toString());
        if (Admin != null){
            return JsonResp.Error("未提交管理员的id");
        }
        assert false;
        Admin Admin1=new Admin();
        BeanUtils.copyProperties(  adminAddDto,Admin1);

        Admin1= adminRepository.save(Admin1);
        if (Admin1.getId()>0){
            return JsonResp.Success("管理员"+adminAddDto.getUsername()+"添加成功");
        }
        return  JsonResp.Error("未知的错误");
    }


    protected Admin buildAdmin(  AdminAddDto adminAddDto){

        return new Admin();
    }

}
