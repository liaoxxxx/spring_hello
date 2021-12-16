package com.liaoxx.spring_hello.service.goods;

import com.liaoxx.spring_hello.entity.goods.GoodsBrand;
import com.liaoxx.spring_hello.repository.goods.GoodsBrandRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsBrandService {



    @Resource
    GoodsBrandRepository brandRepository;



    public Page<GoodsBrand> list(int page, int pageSize) {
        // 排序方式，这里是以“recordNo”为标准进行降序
        Sort sort =  Sort.by(Sort.Direction.DESC, "r");  // 这里的"recordNo"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
        Pageable pageable = new PageRequest(page - 1, 6, sort) {
        }; // （当前页， 每页记录数， 排序方式）
        return brandRepository.findAll(  pageable);

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
            return JsonResp.Error("未提交管理员的id",adminDto);
        }
        BeanUtils.copyProperties(  adminDto,adminModel);
        // System.out.println(adminModel.toString());
        boolean updtBool= brandMapper.Update(adminModel);
        if (updtBool){
            return JsonResp.Success("管理员"+adminDto.getId()+"修改成功",adminDto);
        }
        return  JsonResp.Error("未知的错误",adminDto);
    }

    public Map<String, Object> add(AdminAddDto adminAddDto){
        //避免用户名重复
        AdminModel adminModel=brandMapper.findByUserName(adminAddDto.getUsername());
        System.out.println(adminAddDto.toString());
        if (adminModel != null){
            return JsonResp.Error("未提交管理员的id",adminAddDto);
        }
        assert false;
        AdminModel adminModel1=new AdminModel();
        BeanUtils.copyProperties(  adminAddDto,adminModel1);

        boolean updtBool= brandMapper.install(adminModel1);
        if (updtBool){
            return JsonResp.Success("管理员"+adminAddDto.getUsername()+"添加成功",adminAddDto);
        }
        return  JsonResp.Error("未知的错误",adminAddDto);
    }
*/
/*

    protected AdminModel buildAdminModel(  AdminAddDto adminAddDto){

        return new AdminModel();
    }
*/

}
