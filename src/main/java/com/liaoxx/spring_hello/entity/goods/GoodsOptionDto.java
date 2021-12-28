package com.liaoxx.spring_hello.entity.goods;

import com.liaoxx.spring_hello.entity.DtoI;
import com.liaoxx.spring_hello.entity.EntityI;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
public class GoodsOptionDto implements Serializable, DtoI {
    public GoodsOptionDto() {

    }

    private  Integer id;
    private Integer option_id;  //
    private  BigDecimal supply_costprice;
    private  Integer source_stock;
    private  Integer stock_lock;
    private  Instant created_at;
    private  Instant updated_at;
    private  Integer state;
    private  String source_name;
    private  String source_id;
    private  String productsn;
    private  String goodssn;
    private  String specs;
    private  Integer r;
    private  BigDecimal weight;
    private  Integer stock;
    private  BigDecimal costprice;
    private  BigDecimal marketprice;
    private  BigDecimal productprice;
    private  String thumb;
    private  String title;
    private  Integer goods_id;


    @Override
    public GoodsOptionDto fromEntity(EntityI entity) {
        BeanUtils.copyProperties(entity,this);
        this.option_id=this.id;
        return this;
    }
}
