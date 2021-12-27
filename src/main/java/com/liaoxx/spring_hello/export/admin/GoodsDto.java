package com.liaoxx.spring_hello.export.admin;


import java.util.Arrays;

public class GoodsDto {

    private String shelvesNo;
    private String name;
    private String title;
    private String subTitle;
    private String summary;
    private String volumetric;

    private int sort;
    private int cateId ;

    private String[] thumb;
    private String[] Images;

    private float basePrice;
    private float showPrice;
    private float inputPrice;

    private int status;

    private int storeCount;
    private float weight;
    private int recommendSort;

    private int memberCredit;
    private int experienceCredit;
    /*    */
    private int isShelves;
    private int isNoPostage;
    private int isVisible;
    private int isNew;
    private int isSpecialOffer;
    private int isHot;
    private int isRecommend;

    @Override
    public String toString(){
        return  this.shelvesNo +"\n"+
                this.name +"\n"+
                this.title +"\n"+
                this.subTitle +"\n"+
                this.summary +"\n"+
                this.volumetric +"\n"+
                this.sort +"\n"+
                this.cateId  +"\n"+
                Arrays.toString(this.thumb) +"\n"+
                Arrays.toString(this.Images) +"\n"+
                this.basePrice +"\n"+
                this.showPrice +"\n"+
                this.inputPrice +"\n"+
                this.status +"\n"+
                this.storeCount +"\n"+
                this.weight +"\n"+
                this.recommendSort +"\n"+
                this.memberCredit +"\n"+
                this.experienceCredit +"\n"+
                this.isShelves +"\n"+
                this.isNoPostage +"\n"+
                this.isVisible +"\n"+
                this.isNew +"\n"+
                this.isSpecialOffer +"\n"+
                this.isHot +"\n"+
                this.isRecommend;
    }

    public String getShelvesNo() {
        return shelvesNo;
    }

    public void setShelvesNo(String shelvesNo) {
        this.shelvesNo = shelvesNo;
    }

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

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }


    public String getVolumetric() {
        return volumetric;
    }

    public void setVolumetric(String volumetric) {
        this.volumetric = volumetric;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String[] getThumb() {
        return thumb;
    }

    public void setThumb(String[] thumb) {
        this.thumb = thumb;
    }

    public String[] getImages() {
        return Images;
    }

    public void setImages(String[] images) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStoreCount() {
        return storeCount;
    }

    public void setStoreCount(int storeCount) {
        this.storeCount = storeCount;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getRecommendSort() {
        return recommendSort;
    }

    public void setRecommendSort(int recommendSort) {
        this.recommendSort = recommendSort;
    }

    public int getMemberCredit() {
        return memberCredit;
    }

    public void setMemberCredit(int memberCredit) {
        this.memberCredit = memberCredit;
    }

    public int getExperienceCredit() {
        return experienceCredit;
    }

    public void setExperienceCredit(int experienceCredit) {
        this.experienceCredit = experienceCredit;
    }

    public int getIsShelves() {
        return isShelves;
    }

    public void setIsShelves(int isShelves) {
        this.isShelves = isShelves;
    }

    public int getIsNoPostage() {
        return isNoPostage;
    }

    public void setIsNoPostage(int isNoPostage) {
        this.isNoPostage = isNoPostage;
    }

    public int getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public int getIsSpecialOffer() {
        return isSpecialOffer;
    }

    public void setIsSpecialOffer(int isSpecialOffer) {
        this.isSpecialOffer = isSpecialOffer;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }

    public int getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(int isRecommend) {
        this.isRecommend = isRecommend;
    }
}
