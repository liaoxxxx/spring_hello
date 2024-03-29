package com.liaoxx.spring_hello.export.admin;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "测试")
public class AdminDto {

    private long  id;

    private String username;


    private String nickname;

    private String avatars;

    private byte status;

    //private String roleName;

    //private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
