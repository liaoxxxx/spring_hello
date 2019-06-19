package com.liaoxx.spring_hello.entity;
import javax.persistence.*;

@Entity     //标注为实体类
@Table(name="express_provider")      //标注表名为"admin";
public class ExpressProvider {
    @Id //标注为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //标注为自增主键
    private int  id;
    @Column         //标注为字段
    private String expressProviderName;
    @Column
    private String expressProviderCode;
    @Column
    private String expressProviderChar;
    @Column
    private byte is_delete;
    @Column
    private String remark;
    @Column
    private byte status;
    @Column
    private int created_at;
    @Column
    private int updated_at;


}
