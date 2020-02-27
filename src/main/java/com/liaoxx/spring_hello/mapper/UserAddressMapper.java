package com.liaoxx.spring_hello.mapper;

import com.liaoxx.spring_hello.model.UserAddressModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserAddressMapper {

    List<UserAddressModel> getAll();


    UserAddressModel getById(long id) ;

    void install(UserAddressModel userAddressModel);

    void Update(UserAddressModel userAddressModel);

    void delete(Long id);

}
