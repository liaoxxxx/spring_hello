package com.liaoxx.spring_hello.entity;

import com.liaoxx.spring_hello.entity.AdminDetail;

import javax.persistence.*;

@Entity     //标注为实体类
@Table(name="admin_role")      //标注表名为"admin";
public class AdminRole {
    @Id //标注为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //标注为自增主键
    private int  id;

    @Column()
    private long adminId;

    @Column         //标注为字段
    private int roleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
