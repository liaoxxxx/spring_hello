package com.liaoxx.spring_hello.entity.goods;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(
        value={"hibernateLazyInitializer"}
)
@Table(name = "goods_brand")
public class GoodsBrand {

    @Id //标注为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //标注为自增主键
    @Getter
    @Setter
    private int id;


    @Column//'创建时间'
    @Getter
    @Setter
    private int createdAt;


    @Column//'修改时间'
    @Getter
    @Setter
    private int updatedAt;

    @Column//''狀態 0 待審核  1 審核中 2 正常 4 刪除 -1 已經註銷''
    @Getter
    @Setter
    private int state;



    @Column
    @Getter
    @Setter
    private String name;


    @Column
    @Getter
    @Setter
    private String image;


    @Column
    @Getter
    @Setter
    private String logo;

    @Column//描述
    @Getter
    @Setter
    private String desc;




    @Column//排序
    @Getter
    @Setter
    private int r;


}
