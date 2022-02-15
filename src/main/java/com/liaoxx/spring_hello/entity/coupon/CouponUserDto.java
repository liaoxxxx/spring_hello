package com.liaoxx.spring_hello.entity.coupon;

import com.liaoxx.spring_hello.entity.DtoI;
import com.liaoxx.spring_hello.entity.EntityI;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
public class CouponUserDto implements Serializable , DtoI {
    public Integer id;
    public BigDecimal full_price;
    public Integer uid;
    public Integer etime;
    public Integer ctime;
    public Integer ty;
    public Integer resource_id;
    public Integer resource;
    public String name;
    public Integer state;
    public Instant updated_at;
    public Instant created_at;

    @Override
    public CouponUserDto fromEntity(EntityI entity) {
        BeanUtils.copyProperties(entity,this);
        return this;
    }
}
