package com.liaoxx.spring_hello.entity.coupon;

import com.liaoxx.spring_hello.entity.EntityI;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity(name = "Coupon_User")
@Table(name = "coupon_user")
public class CouponUser implements EntityI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Instant created_at;

    private Instant updated_at;

    private Integer state;

    private String name;

    private Integer resource;

    private Integer resource_id;

    private Integer ty;

    private Integer ctime;

    private Integer etime;

    private Integer uid;

    private BigDecimal full_price;

    @Column(name = "full_price", nullable = false, precision = 11)
    public BigDecimal getFull_price() {
        return full_price;
    }

    public void setFull_price(BigDecimal fullPrice) {
        this.full_price = fullPrice;
    }

    @Column(name = "uid", nullable = false)
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Column(name = "etime", nullable = false)
    public Integer getEtime() {
        return etime;
    }

    public void setEtime(Integer etime) {
        this.etime = etime;
    }

    @Column(name = "ctime", nullable = false)
    public Integer getCtime() {
        return ctime;
    }

    public void setCtime(Integer ctime) {
        this.ctime = ctime;
    }

    @Column(name = "ty", nullable = false)
    public Integer getTy() {
        return ty;
    }

    public void setTy(Integer ty) {
        this.ty = ty;
    }

    @Column(name = "resource_id", nullable = false)
    public Integer getResource_id() {
        return resource_id;
    }

    public void setResource_id(Integer resource_id) {
        this.resource_id = resource_id;
    }

    @Column(name = "resource", nullable = false)
    public Integer getResource() {
        return resource;
    }

    public void setResource(Integer resource) {
        this.resource = resource;
    }

    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "state", nullable = false)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Column(name = "updated_at", nullable = false)
    public Instant getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Instant updated_at) {
        this.updated_at = updated_at;
    }

    @Column(name = "created_at", nullable = false)
    public Instant getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Instant createdAt) {
        this.created_at = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}