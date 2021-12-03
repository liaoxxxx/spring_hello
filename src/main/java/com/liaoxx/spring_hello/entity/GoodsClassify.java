package com.liaoxx.spring_hello.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Entity
@JsonIgnoreProperties(
        value={"hibernateLazyInitializer"}
)
@Table(name = "goods_classify")
public class GoodsClassify {

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
    private String image;


    @Column//父级
    @Getter
    @Setter
    private int pid;


    @Column//'级别'
    @Getter
    @Setter
    private int level;

    @Column//排序
    @Getter
    @Setter
    private int r;


    @Column//'父级'
    @Getter
    @Setter
    private String name;


    @Column//'外部ID'
    @Getter
    @Setter
    private int source_id;


    @Column//'同步的来源'
    @Getter
    @Setter
    private String source_name;

}
