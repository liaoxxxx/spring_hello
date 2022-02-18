package com.liaoxx.spring_hello.entity.user;

import javax.persistence.*;
import java.time.Instant;

@Entity(name = "User_Grade")
@Table(name = "user_grade")
public class UserGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Instant created_at;

    private Instant updated_at;

    private String name;

    private Double consumption;

    private Integer customer;

    private Integer shipping;

    private Integer shop;

    private Integer state;

    private Integer level;

    private Integer useprice;

    private Integer channelId;

    @Column(name = "channel_id")
    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    @Column(name = "useprice", nullable = false)
    public Integer getUseprice() {
        return useprice;
    }

    public void setUseprice(Integer useprice) {
        this.useprice = useprice;
    }

    @Column(name = "level", nullable = false)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Column(name = "state", nullable = false)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Column(name = "shop", nullable = false)
    public Integer getShop() {
        return shop;
    }

    public void setShop(Integer shop) {
        this.shop = shop;
    }

    @Column(name = "shipping", nullable = false)
    public Integer getShipping() {
        return shipping;
    }

    public void setShipping(Integer shipping) {
        this.shipping = shipping;
    }

    @Column(name = "customer", nullable = false)
    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    @Column(name = "consumption", nullable = false)
    public Double getConsumption() {
        return consumption;
    }

    public void setConsumption(Double consumption) {
        this.consumption = consumption;
    }

    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}