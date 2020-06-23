package com.liaoxx.spring_hello.mapper;

import com.liaoxx.spring_hello.model.AdminModel;
import com.liaoxx.spring_hello.model.GoodsBrandModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GoodsBrandMapper {

    //@Select("SELECT * FROM `brand`  ORDER BY   #{orderField} DESC   LIMIT  #{limitStart} , #{limitEnd}  ")
    @Select("SELECT * FROM `brand`  ORDER BY   #{orderField} DESC   LIMIT  #{limitStart} , #{limitEnd}  ")
    List<GoodsBrandModel> getByPage(String orderField, int limitStart, int limitEnd);


    @Select("select * from brand where id=#{id}")
    AdminModel getById(long id) ;

   /* @Select("select * from brand where username=#{username}")
    AdminModel findByUserName(String username) ;

    @Insert("INSERT INTO brand( username , password , salt , nickname , avatars , is_delete, status ) VALUES( #{username} , #{password}, #{salt} , #{nickname} , #{avatars} , #{isDelete} , #{status} )")
    boolean install(AdminModel adminModel);

    @Update({"UPDATE brand SET username=#{username} ,password =#{password} ,salt =#{salt} ,nickname =#{nickname},avatars =#{avatars} ,is_delete=#{isDelete},status =#{status} WHERE id = #{id}"})
    boolean Update(AdminModel adminModel);

    @Delete("delete from brand where id=#{id}")
    void delete(Long id);*/


}
