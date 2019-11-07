package com.liaoxx.spring_hello.entity;

import javax.persistence.*;
@Entity
@Table(name="goods_category")
public class GoodsCategory {
    @Id //标注为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //标注为自增主键
    private int  id;

    @Column
    private String cateName;
    @Column
    private int parentId;
    @Column
    private String summary;

    @Column
    private byte status;



    @Column
    private String thumb;
    @Column
    private int created_at;
    @Column
    private int updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
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
