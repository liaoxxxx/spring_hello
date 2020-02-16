package com.liaoxx.spring_hello.entity;

public class JwtPayloadEntity {
    private String role;

    private  int UserId;
    private String sub;

    private  String iss;
    private  int iat;

    private  String aud;
    private  int exp;

    private  int nbf;

    public void setRole(String role) {
        this.role = role;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public void setIat(int iat) {
        this.iat = iat;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setNbf(int nbf) {
        this.nbf = nbf;
    }

    public String getRole() {
        return role;
    }

    public int getUserId() {
        return UserId;
    }

    public String getSub() {
        return sub;
    }

    public String getIss() {
        return iss;
    }

    public int getIat() {
        return iat;
    }

    public String getAud() {
        return aud;
    }

    public int getExp() {
        return exp;
    }

    public int getNbf() {
        return nbf;
    }
}
