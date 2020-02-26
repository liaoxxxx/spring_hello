package com.liaoxx.spring_hello.model;

import java.io.Serializable;

public class UserModel implements Serializable {

    private long  id;

    private String username;

    private String password;

    private String salt;

    private String nickname;

    private byte isDelete;

    private String avatars;

    private byte status;

    @Override
    public String toString(){
        return  "Admin:@id:"+this.getId()+";\r\n"
                +"@username: "+this.getUsername()+";\r\n"

                +"@password: "+this.getPassword()+";\r\n"
                +"@salt: "+this.getSalt()+";\r\n"

                +"@nickname: "+this.getNickname()+";\r\n"
                +"@isDelete: "+this.getIsDelete()+";\r\n"

                +"@avatars: "+this.getAvatars()+";\r\n"
                +"@status: "+this.getStatus()+";\r\n";
    }

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

    public byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(byte isDelete) {
        this.isDelete = isDelete;
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
