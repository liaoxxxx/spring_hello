package com.liaoxx.spring_hello.export.admin;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "测试")
public class AdminAddDto {


    private String username;

    private String password;

    private String salt;

    private String nickname;

    private byte isDelete =0;

    private byte isAdministrator =0;

    private String avatars;

    private byte status =1;

    @Override
    public String toString(){
        return "@username: "+this.getUsername()+";\r\n"

                +"@password: "+this.getPassword()+";\r\n"
                +"@salt: "+this.getSalt()+";\r\n"

                +"@nickname: "+this.getNickname()+";\r\n"
                +"@isDelete: "+this.getIsDelete()+";\r\n"

                +"@avatars: "+this.getAvatars()+";\r\n"
                +"@status: "+this.getStatus()+";\r\n";
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

    private byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(byte isDelete) {
        this.isDelete = isDelete;
    }


    public byte getIsAdministrator() {
        return isAdministrator;
    }

    public void setIsAdministrator(byte isAdministrator) {
        this.isAdministrator = isAdministrator;
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
