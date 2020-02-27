package com.liaoxx.spring_hello.model;
import java.io.Serializable;

public class UserAddressModel implements Serializable {

    private long  id;

    private long userId;

    private String province;

    private String city;

    private String address;

    private String zipCode;

    private byte isDelete;

    private byte status;

    @Override
    public String toString(){
        return  "Admin:@id:"+this.getId()+";\r\n"
                +"@userId: "+this.getUserId()+";\r\n"

                +"@province: "+this.getProvince()+";\r\n"
                +"@city: "+this.getCity()+";\r\n"

                +"@address: "+this.getAddress()+";\r\n"
                +"@zipCode: "+this.getZipCode()+";\r\n"

                +"@isDelete: "+this.getIsDelete()+";\r\n"
                +"@status: "+this.getStatus()+";\r\n";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(byte isDelete) {
        this.isDelete = isDelete;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}

