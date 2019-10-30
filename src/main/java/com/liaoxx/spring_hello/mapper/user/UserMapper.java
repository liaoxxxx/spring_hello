package com.liaoxx.spring_hello.mapper.user;

import com.liaoxx.spring_hello.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import java.util.List;
public interface UserMapper {
    @Select("select * from UserInfoInfo")
    @Results({
            @Result(property = "UserInfoname", column = "UserInfoname")
    })
    List<UserInfo> getAll();

    @Select("select * from UserInfo where id=#{id}")
    UserInfo getById(long id) ;

    @Insert("insert into UserInfo(UserInfoname,password,salt) values(#{UserInfoname},#{password},#{salt})")
    void install(UserInfo UserInfo);

    @Update({"update UserInfo set UserInfoname=#{UserInfoname} where id=#{id}"})
    void Update(UserInfo UserInfo);

    @Delete("delete from UserInfo where id=#{id}")
    void delete(Long id);

}
