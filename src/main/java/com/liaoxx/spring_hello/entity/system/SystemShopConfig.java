package com.liaoxx.spring_hello.entity.system;

public class SystemShopConfig {


    private int privateDomain;
    private String cDomain;
    private String bDomain;
    private int isZgbury;
    private int isRenlian;

    public void setPrivateDomain(int privateDomain) {
        this.privateDomain = privateDomain;
    }

    public int getPrivateDomain() {
        return privateDomain;
    }

    public void setCDomain(String cDomain) {
        this.cDomain = cDomain;
    }

    public String getCDomain() {
        return cDomain;
    }

    public void setBDomain(String bDomain) {
        this.bDomain = bDomain;
    }

    public String getBDomain() {
        return bDomain;
    }

    public void setIsZgbury(int isZgbury) {
        this.isZgbury = isZgbury;
    }

    public int getIsZgbury() {
        return isZgbury;
    }

    public void setIsRenlian(int isRenlian) {
        this.isRenlian = isRenlian;
    }

    public int getIsRenlian() {
        return isRenlian;
    }

}
