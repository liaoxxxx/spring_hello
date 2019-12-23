package com.liaoxx.spring_hello.dto.admin;


public class GoodsDto {


    private String name;

    private String title;

    private String subTitle;

    private String summary;

    private int cateId ;

    private String Images;

    private float basePrice;

    private float showPrice;


    private float inputPrice;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images = images;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public float getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(float showPrice) {
        this.showPrice = showPrice;
    }

    public float getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(float inputPrice) {
        this.inputPrice = inputPrice;
    }
}
