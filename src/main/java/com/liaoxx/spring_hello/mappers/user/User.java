package com.liaoxx.spring_hello.mappers.user;

public class User {
    private  long id;
    private  String name;
    private  String password;
    private  long salt;
    private  byte status;
    private  byte is_delete;
    private  int created_at;
    private  int updated_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getSalt() {
        return salt;
    }

    public void setSalt(long salt) {
        this.salt = salt;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public byte getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(byte is_delete) {
        this.is_delete = is_delete;
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
