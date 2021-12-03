package com.liaoxx.spring_hello.entity;


import javax.persistence.*;

@Entity     //标注为实体类
@Table(name="admin_user_role")      //标注表名为"admin";
public class AdminUserRole {
    @Id //标注为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //标注为自增主键
    private int  id;

    @Column()
    private long adminId;

    @Column         //标注为字段
    private int roleId;

    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public int getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(int updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Column         //'创建时间'
    private int createdAt;
    @Column         //'修改时间'
    private int updatedAt;
    @Column         //''狀態 0 待審核  1 審核中 2 正常 4 刪除 -1 已經註銷''
    private int state;

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


