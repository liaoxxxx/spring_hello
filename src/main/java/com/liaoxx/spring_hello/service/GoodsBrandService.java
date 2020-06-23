package com.liaoxx.spring_hello.service;

import com.liaoxx.spring_hello.mapper.GoodsBrandMapper;
import com.liaoxx.spring_hello.model.GoodsBrandModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GoodsBrandService {



    @Autowired
    GoodsBrandMapper brandMapper;



    public List<GoodsBrandModel> getBrandByPage(int page, int pageSize) {

        List<GoodsBrandModel> brandModelList = brandMapper.getByPage( "`id`", 0, 20);
        //List<AdminModel> adminList = adminMapper.getByPage(0, 20);
        return brandModelList;

    }

  /*  public AdminDto getBrandDtoById(int id){
        AdminModel admin= brandMapper.getById(id);
        AdminDto adminDto=new AdminDto();
        BeanUtils.copyProperties(admin,adminDto);
        return adminDto;
    }*/

   /* public Map<String, Object> edit(AdminDto adminDto){

        AdminModel adminModel=brandMapper.getById(adminDto.getId());
        if (adminModel==null){
            return JsonResponse.Error("未提交管理员的id",adminDto);
        }
        BeanUtils.copyProperties(  adminDto,adminModel);
        // System.out.println(adminModel.toString());
        boolean updtBool= brandMapper.Update(adminModel);
        if (updtBool){
            return JsonResponse.Success("管理员"+adminDto.getId()+"修改成功",adminDto);
        }
        return  JsonResponse.Error("未知的错误",adminDto);
    }

    public Map<String, Object> add(AdminAddDto adminAddDto){
        //避免用户名重复
        AdminModel adminModel=brandMapper.findByUserName(adminAddDto.getUsername());
        System.out.println(adminAddDto.toString());
        if (adminModel != null){
            return JsonResponse.Error("未提交管理员的id",adminAddDto);
        }
        assert false;
        AdminModel adminModel1=new AdminModel();
        BeanUtils.copyProperties(  adminAddDto,adminModel1);

        boolean updtBool= brandMapper.install(adminModel1);
        if (updtBool){
            return JsonResponse.Success("管理员"+adminAddDto.getUsername()+"添加成功",adminAddDto);
        }
        return  JsonResponse.Error("未知的错误",adminAddDto);
    }
*/
/*

    protected AdminModel buildAdminModel(  AdminAddDto adminAddDto){

        return new AdminModel();
    }
*/

}
