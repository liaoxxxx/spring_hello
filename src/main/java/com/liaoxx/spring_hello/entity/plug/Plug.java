package com.liaoxx.spring_hello.entity.plug;

import javax.persistence.*;
import java.time.Instant;

@Entity(name = "Plug")
@Table(name = "plug")
public class Plug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Instant createdAt;

    private Instant updatedAt;

    private String key;

    private String desc;

    private Integer state;

    @Column(name = "state", nullable = false)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Column(name = "`desc`", nullable = false, length = 11)
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Column(name = "`key`", nullable = false, length = 11)
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Column(name = "updated_at", nullable = false)
    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Column(name = "created_at", nullable = false)
    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}