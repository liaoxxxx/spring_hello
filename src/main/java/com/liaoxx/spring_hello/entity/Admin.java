package com.liaoxx.spring_hello.entity;
import javax.persistence.*;
@Entity     //标注为实体类
@Table(name="admin")      //标注表名为"admin";
public class Admin {
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
    private byte is_delete;
    @Column
    private byte is_administrator;
    @Column
    private String avatars;
    @Column
    private byte status;

    @Column
    private int role_id;



    @OneToOne(cascade = CascadeType.ALL,targetEntity = AdminDetail.class)
    @JoinColumn(name = "admin_detail_id", referencedColumnName = "id", insertable = false, updatable = false)
    private AdminDetail adminDetail;


    public AdminDetail getAdminDetail() {
        return adminDetail;
    }

    public void setAdminDetail(AdminDetail adminDetail) {
        this.adminDetail = adminDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public byte getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(byte is_delete) {
        this.is_delete = is_delete;
    }

    public byte getIs_administrator() {
        return is_administrator;
    }

    public void setIs_administrator(byte is_administrator) {
        this.is_administrator = is_administrator;
    }

    public String getAvatars() {
        return avatars;
    }

    public void setAvatars(String avatars) {
        this.avatars = avatars;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }



}
