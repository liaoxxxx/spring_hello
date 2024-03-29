package com.liaoxx.spring_hello.entity.goods;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "goods_special")
@Entity
public class GoodsSpecial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "state", nullable = false)
    private Integer state;

    @Column(name = "stime", nullable = false)
    private Integer stime;

    @Column(name = "etime", nullable = false)
    private Integer etime;

    @Column(name = "r", nullable = false)
    private Integer r;

    @Column(name = "`desc`", nullable = false, length = 1024)
    private String desc;

    @Column(name = "logo", nullable = false)
    private String logo;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "poster", nullable = false)
    private String poster;

    @Lob
    @Column(name = "thumbs", nullable = false)
    private String thumbs;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "is_recommand", nullable = false)
    private Integer isRecommand;

    @Column(name = "source_id", nullable = false, length = 64)
    private String sourceId;

    @Column(name = "source_name", nullable = false, length = 128)
    private String sourceName;

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getIsRecommand() {
        return isRecommand;
    }

    public void setIsRecommand(Integer isRecommand) {
        this.isRecommand = isRecommand;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getThumbs() {
        return thumbs;
    }

    public void setThumbs(String thumbs) {
        this.thumbs = thumbs;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public Integer getEtime() {
        return etime;
    }

    public void setEtime(Integer etime) {
        this.etime = etime;
    }

    public Integer getStime() {
        return stime;
    }

    public void setStime(Integer stime) {
        this.stime = stime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

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