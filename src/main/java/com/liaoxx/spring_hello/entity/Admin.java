package com.liaoxx.spring_hello.entity;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import java.util.List;
@Entity     //标注为实体类
@Table(name="admin_u")      //标注表名为"admin";
public class Admin {
    @Id //标注为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //标注为自增主键
    private long  id;


    @Column         //标注为字段
    private String username;
    @Column
    private String password;
    @Column
    private String salt;
    @Column
    private String nickname;
    @Column
    private byte isDelete;
    @Column
    private byte isAdministrator;
    @Column
    private String avatars;
    @Column
    private byte status;





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

    public byte getIs_delete() {
        return isDelete;
    }

    public void setIs_delete(byte isDelete) {
        this.isDelete = isDelete;
    }

    public byte getIs_administrator() {
        return isAdministrator;
    }

    public void setIs_administrator(byte is_administrator) {
        this.isAdministrator = is_administrator;
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
