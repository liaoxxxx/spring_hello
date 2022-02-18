package com.liaoxx.spring_hello.entity.user;

import com.liaoxx.spring_hello.entity.DtoI;
import com.liaoxx.spring_hello.entity.EntityI;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.sql.Date;

@Data
public class UserDto implements Serializable, DtoI {
    public UserDto() {

    }
    public  long id;
    public  Date created_at;
    public  Date updated_at;
    public  String username;
    public  String avatar;
    public  int state;
    public  int sex;
    public  String phone;
    public  String email;
    public  String source;
    public  int agent_id;
    public  int grade_id;
    public  String nickname;
    public  String remarks;
    public  String birthday;
    public  String administration_address;
    public  int is_register_product;
    public  int is_write_profile;
    public        UserGrade grade;


    @Override
    public UserDto fromEntity(EntityI entity) {
        BeanUtils.copyProperties(entity,this);
        return this;
    }
}
