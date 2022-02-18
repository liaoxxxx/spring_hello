package com.liaoxx.spring_hello.entity.goods;

import com.liaoxx.spring_hello.entity.DtoI;
import com.liaoxx.spring_hello.entity.EntityI;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Data
public class GoodsOptionDto implements Serializable, DtoI {
    public GoodsOptionDto() {

    }
    @Getter
    @Setter
    private  Integer id;
    @Getter
    @Setter
    private Integer option_id;



    public int getOptionId(){
        return  this.option_id;
    }
    @Getter
    @Setter  //
    private  double supply_costprice;
    @Getter
    @Setter
    private  Integer source_stock;
    @Getter
    @Setter
    private  Integer stock_lock;
    @Getter
    @Setter
    private  Instant created_at;
    @Getter
    @Setter
    private  Instant updated_at;
    @Getter
    @Setter
    private  Integer state;
    @Getter
    @Setter
    private  String source_name;
    @Getter
    @Setter
    private  String source_id;
    @Getter
    @Setter
    private  String productsn;
    @Getter
    @Setter
    private  String goodssn;
    @Getter
    @Setter
    private  String specs;
    @Getter
    @Setter
    private  Integer r;
    @Getter
    @Setter
    private  double weight;
    @Getter
    @Setter
    private  Integer stock;
    @Getter
    @Setter
    private  double costprice;
    @Getter
    @Setter
    private  double marketprice;
    @Getter
    @Setter
    private  double productprice;
    @Getter
    @Setter
    private  String thumb;
    @Getter
    @Setter
    private  String title;
    @Getter
    @Setter
    private  Integer goods_id;

    @Getter
    @Setter
    private String Attr;  //
    @Getter
    @Setter
    private long Brand_id;//活动ID
    @Getter
    @Setter
    private long Option_id;//sku的id
    @Getter
    @Setter
    private double Profit;  //利润
    @Getter
    @Setter
    private double Price;  //收益
    @Getter
    @Setter
    private long Resource_id;//活动的ID
    @Getter
    @Setter
    private String Source_sku_id; //来源skuID
    @Getter
    @Setter
    private String Brand_name;  //活动的ID
    @Getter
    @Setter
    private String Ty_name;  //活动的ID
    @Getter
    @Setter
    private List<String> Spec;        //活动的ID


    @Override
    public GoodsOptionDto fromEntity(EntityI entity) {
        BeanUtils.copyProperties(entity,this);
        this.option_id=this.id;
        return this;
    }
}
