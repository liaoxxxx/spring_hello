package com.liaoxx.spring_hello.mapper;

import com.liaoxx.spring_hello.model.UserAddressModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserAddressMapper {
    @Select("SELECT  *　FROM 　user_address   WHERE is_delete = 0")
    List<UserAddressModel> getAll();

    @Select("SELECT  *　FROM 　user_address WHERE id =#{id} ,is_delete = 0")
    UserAddressModel getById(long id) ;

    @Insert("INSERT INTO　user_address ( user_id , province , city , address , zip_code )　VALUE( #{userId} ,#{province}, #{city} ,#{address}, #{zipCode})")
    void insert(UserAddressModel userAddressModel);

    @Update("UPDATE user_address SET " +
            "user_id =#{userId} ," +
            "province = #{province} ," +
            "city = #{city} ," +
            "address =#{address} ," +
            "zip_code =#{zipCode} , " +
            "is_delete = #{isDelete} ," +
            "`status` =#{status} " +
            "WHERE  id =#{id}  ")
    void Update(UserAddressModel userAddressModel);

    @Delete("DELETE　FROM user_address WHERE id = #{id}")
    void delete(Long id);

}
