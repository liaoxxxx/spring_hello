package com.liaoxx.spring_hello.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity     //标注为实体类
@Table(name = "user")      //标注表名为"admin";
public class User implements Serializable {

    @Id //标注为主键
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //标注为自增主键
    private long id;


    @Column
    @Getter
    @Setter
    private Date created_at;


    @Column
    @Getter
    @Setter
    private Date updated_at;

    @Column
    @Getter
    @Setter
    private String username;

    @Column
    @Getter
    @Setter
    private String password;

    @Column
    @Getter
    @Setter
    private String salt;

    @Column
    @Getter
    @Setter
    private String avatar;

    @Column
    @Getter
    @Setter
    private int state;

    @Column
    @Getter
    @Setter
    private int sex;

    @Column
    @Getter
    @Setter
    private String phone;

    @Column
    @Getter
    @Setter
    private String email;

    @Column
    @Getter
    @Setter
    private String source;

    @Column
    @Getter
    @Setter
    private int agent_id;

    @Column
    @Getter
    @Setter
    private int grade_id;

    @Column
    @Getter
    @Setter

    private String nickname;

    @Column
    @Getter
    @Setter
    private String remarks;

    @Column
    @Getter
    @Setter
    private String birthday;

    @Column
    @Getter
    @Setter
    private String administration_address;

    @Column
    @Getter
    @Setter
    private int is_register_product;

    @Column
    @Getter
    @Setter
    private int is_write_profile;


}
