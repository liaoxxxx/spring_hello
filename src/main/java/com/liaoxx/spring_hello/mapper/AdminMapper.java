package com.liaoxx.spring_hello.mapper;

import com.liaoxx.spring_hello.model.AdminModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdminMapper {

    @Select("SELECT * FROM `admin`  ORDER BY   #{orderField} DESC   LIMIT  #{limitStart} , #{limitEnd}  ")
    List<AdminModel> getByPage(String orderField ,int limitStart ,int limitEnd);


    @Select("select * from admin where id=#{id}")
    AdminModel getById(long id) ;

    @Select("select * from admin where username=#{username}")
    AdminModel findByUserName(String username) ;

    @Insert("INSERT INTO admin( username , password , salt , nickname , avatars , is_delete, status ) VALUES( #{username} , #{password}, #{salt} , #{nickname} , #{avatars} , #{isDelete} , #{status} )")
    void install(AdminModel adminModel);

    @Update({"UPDATE admin SET username=#{username} ,password =#{password} ,salt =#{salt} ,nickname =#{nickname},avatars =#{avatars} ,is_delete=#{isDelete},status =#{status} WHERE id = #{id}"})
    boolean Update(AdminModel adminModel);

    @Delete("delete from admin where id=#{id}")
    void delete(Long id);


}
