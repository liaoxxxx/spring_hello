package com.liaoxx.spring_hello.mapper.user;

import com.liaoxx.spring_hello.entity.User;
import org.apache.ibatis.annotations.*;
import java.util.List;
public interface UserMapper {
    @Select("select * from user")
    @Results({
            @Result(property = "username", column = "username")
    })
    List<User> getAll();

    @Select("select * from user where id=#{id}")
    User getById(long id) ;

    @Insert("insert into user(username,password,salt) values(#{username},#{password},#{salt})")
    void install(User user);

    @Update({"update user set username=#{username} where id=#{id}"})
    void Update(User user);

    @Delete("delete from user where id=#{id}")
    void delete(Long id);

}
