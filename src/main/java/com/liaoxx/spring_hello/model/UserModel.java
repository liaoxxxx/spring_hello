package com.liaoxx.spring_hello.model;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {
    private long id;
    private Date created_at;
    private Date updated_at;
    private String username;
    private String password;
    private String salt;
    private String avatar;
    private int state;
    private int sex;
    private String phone;
    private String email;
    private String source;
    private int agent_id;
    private int grade_id;
    private String nickname;
    private String remarks;
    private String birthday;
    private String administration_address;
    private int is_register_product;
    private int is_write_profile;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSalt() {
        return salt;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSex() {
        return sex;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public int getAgent_id() {
        return agent_id;
    }


    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setAdministration_address(String administration_address) {
        this.administration_address = administration_address;
    }

    public String getAdministration_address() {
        return administration_address;
    }

    public void setIs_register_product(int is_register_product) {
        this.is_register_product = is_register_product;
    }

    public int getIs_register_product() {
        return is_register_product;
    }

    public void setIs_write_profile(int is_write_profile) {
        this.is_write_profile = is_write_profile;
    }

    public int getIs_write_profile() {
        return is_write_profile;
    }

}
