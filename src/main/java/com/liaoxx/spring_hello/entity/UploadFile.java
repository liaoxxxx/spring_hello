package com.liaoxx.spring_hello.entity;
import javax.persistence.*;
@Entity     //标注为实体类
@Table(name="upload_file")      //标注表名为"admin";
public class UploadFile {
    @Id //标注为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //标注为自增主键
    private int  id;

    @Column
    private String path;

    @Column
    private long createdAt;
    @Column
    private long updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdated_at() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
