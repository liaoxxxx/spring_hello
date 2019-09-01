package com.liaoxx.spring_hello.entity;

import javax.persistence.*;

public class SalesOrder {
        @Id //标注为主键
        @GeneratedValue(strategy = GenerationType.IDENTITY)  //标注为自增主键
        private int  id;
        @Column         //标注为字段
        private String username;
        @Column
        private String password;
        @Column
        private String salt;
        @Column
        private String nickname;
        @Column
        private String phone;
        @Column
        private String email;
        @Column
        private byte is_delete;
        @Column
        private byte is_administrator;
        @Column
        private String avatars;
        @Column
        private byte sexy;
        @Column
        private String remark;
        @Column
        private byte status;
        @Column
        private int created_at;
        @Column
        private int updated_at;


}

