package com.liaoxx.spring_hello.entity.user;

import com.liaoxx.spring_hello.entity.DtoI;
import com.liaoxx.spring_hello.entity.EntityI;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class UserGradeDto implements Serializable , DtoI {
    public Integer id;
    public Integer channelId;
    public Integer useprice;
    public Integer level;
    public Integer state;
    public Integer shop;
    public Integer shipping;
    public Integer customer;
    public Double consumption;
    public String name;
    public Instant updated_at;
    public Instant created_at;

    @Override
    public UserGradeDto fromEntity(EntityI entity) {
        return this;
    }
}
