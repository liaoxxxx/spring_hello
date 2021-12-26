package com.liaoxx.spring_hello.entity.goods;

import javax.persistence.*;

@Entity(name = "Goods_Spec_Item")
@Table(name = "goods_spec_item")
public class GoodsSpecItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Integer specid;

    private String title;

    private String source_id;

    private String source_name;

    private Integer goods_id;

    private String titleFull;

    @Column(name = "title_full")
    public String getTitleFull() {
        return titleFull;
    }

    public void setTitleFull(String titleFull) {
        this.titleFull = titleFull;
    }

    @Column(name = "goods_id", nullable = false)
    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goodsId) {
        this.goods_id = goodsId;
    }

    @Column(name = "source_name", nullable = false, length = 100)
    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String sourceName) {
        this.source_name = sourceName;
    }

    @Column(name = "source_id", nullable = false, length = 100)
    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "specid", nullable = false)
    public Integer getSpecid() {
        return specid;
    }

    public void setSpecid(Integer specid) {
        this.specid = specid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}