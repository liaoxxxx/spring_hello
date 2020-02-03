package com.liaoxx.spring_hello.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity     //标注为实体类
@Table(name="admin_detail")      //标注表名为"admin";
public class AdminDetail implements Serializable {
    @Id //标注为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //标注为自增主键
    private int  id;

    /*@Column
    private int adminId;*/

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private byte sexy;

    @Column
    private String remark;

    @Column
    private int created_at;

    @Column
    private int updated_at;


    @Id
    @OneToOne(mappedBy="adminDetail", fetch=FetchType.EAGER)
    private Admin admin;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    /*public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }*/

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public byte getSexy() {
        return sexy;
    }
    public void setSexy(byte sexy) {
        this.sexy = sexy;
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getCreated_at() {
        return created_at;
    }
    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public int getUpdated_at() {
        return updated_at;
    }
    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }
}
