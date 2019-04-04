package com.liaoxx.spring_hello.entity;

public class User {
    private long id ;
    private String username ;
    private String password;
    private String salt ;


    public Long getId() {
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

    public String getPasswd() {
        return password;
    }
    public void setPasswd(String passwd) {
        this.password = passwd;
    }

    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }
}
