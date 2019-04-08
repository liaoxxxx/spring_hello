package com.liaoxx.spring_hello.entity;

import javax.persistence.Entity;

@Entity
public class Admin {

    private int  id;
    private String username;
    private String password;
    private String salt;
    private String nickname;
    private String phone;
    private String email;
    private byte is_delete;
    private byte is_administrator;
    private String avatars;
    private byte sexy;
    private String remark;
    private byte status;
    private int created_at;
    private int updated_at;

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

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
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
