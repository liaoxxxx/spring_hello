package com.liaoxx.spring_hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="goods_category")
public class GoodsCategory {
    @Id //标注为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //标注为自增主键
    private int  id;

    @NotBlank(message ="分类的名称不能为空")
    @Column
    private String cateName;

    @NotNull(message = "分类的父级不能为空")
    @Column
    private int parentId;

    @NotBlank(message ="分类的描述不能为空")
    @Column
    private String summary;

    @NotNull
    @Column
    private byte status;

    @NotNull
    @Column
    private Long createdAt;

    @Column
    @NotNull
    private Long updatedAt;




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


    public long getCreated_at() {
        return createdAt;
    }

    public void setCreated_at(long created_at) {
        this.createdAt = created_at;
    }

    public long getUpdated_at() {
        return updatedAt;
    }

    public void setUpdated_at(long updated_at) {
        this.updatedAt = updated_at;
    }



}
