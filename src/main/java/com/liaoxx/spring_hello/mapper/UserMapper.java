package com.liaoxx.spring_hello.mapper;

import com.liaoxx.spring_hello.model.UserModel;
import org.apache.ibatis.annotations.*;
import java.util.List;
public interface UserMapper {
    @Select("select * from user")
    @Results({
            @Result(property = "isDelete", column = "id_delete")
    })
    List<UserModel> getAll();

    @Select("select * from user where id=#{id}")
    UserModel getById(long id) ;

    @Insert("INSERT INTO user( username , password , salt , nickname , avatars , is_delete, status ) VALUES( #{username} , #{password}, #{salt} , #{nickname} , #{avatars} , #{isDelete} , #{status} )")
    void install(UserModel user);

    @Update({"UPDATE user SET username=#{username} ,password =#{password} ,salt =#{salt} ,nickname =#{nickname},avatars =#{avatars} is_delete=#{isDelete},status =#{status} WHERE id = #{id}"})
    void Update(UserModel userModel);

    @Delete("delete from user where id=#{id}")
    void delete(Long id);

}
