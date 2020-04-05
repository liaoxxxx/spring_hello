package com.liaoxx.spring_hello.dto.admin;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "测试")
public class AdminDto {

    private int  aid;

    private String username;


    private String nickname;

    private String avatars;

    private byte status;

    //private String roleName;

    //private String description;

    public int getId() {
        return aid;
    }

    public void setId(int id) {
        this.aid = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

   /* public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }*/
}
