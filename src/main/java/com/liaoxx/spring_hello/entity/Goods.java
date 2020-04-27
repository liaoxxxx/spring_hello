package com.liaoxx.spring_hello.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@JsonIgnoreProperties(
        value={"hibernateLazyInitializer"}
)
@Table(name="goods")
public class Goods {
    @Id //标注为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //标注为自增主键
    private int  id;

    @NotNull(message = "商品的父级不能为空")
    @Column
    private String name;

    @NotNull(message ="商品的名称不能为空")
    @Column
    private int cateId;


    @Column
    private int recommendSort;



    @NotBlank(message ="商品的标题不能为空")
    @Column
    private String title;


    @NotNull(message ="商品的副标题不能为空")
    @Column
    private String subTitle;

    @NotBlank(message ="商品的描述不能为空")
    @Column
    private String summary;

    //@NotBlank(message ="商品的描述不能为空")
    @Column
    private String images;

    @Column
    private String thumb;  // 缩略图

    @NotNull
    @Column
    private float basePrice;


    @NotNull
    @Column
    private float inputPrice;

    @NotNull
    @Column
    private byte showPrice;

    @NotNull
    @Column
    private byte status;

    @NotNull
    @Column
    private byte isDelete;

    @NotNull
    @Column
    private Long createdAt;

    @Column
    @NotNull
    private Long updatedAt;

    @Column
    @NotNull
    private String shelvesNo;

    @Column
    @NotNull
    private String volumetric;
    @Column
    @NotNull
    private int sort;


    @Column
    @NotNull
    private int storeCount;
    @Column
    @NotNull
    private float weight;

    @Column
    @NotNull
    private int memberCredit;
    @Column
    @NotNull
    private int experienceCredit;

    @Column
    @NotNull
    private int isShelves;
    @Column
    @NotNull
    private int isNoPostage;
    @Column
    @NotNull
    private int isVisible;
    @Column
    @NotNull
    private int isNew;
    @Column
    @NotNull
    private int isSpecialOffer;
    @Column
    @NotNull
    private int isHot;
    @Column
    @NotNull
    private int isRecommend;

    private String updateAtStr;

    private String createdAtStr;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public float getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(float inputPrice) {
        this.inputPrice = inputPrice;
    }

    public byte getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(byte showPrice) {
        this.showPrice = showPrice;
    }

    public byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(byte isDelete) {
        this.isDelete = isDelete;
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

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdateAtStr() {
        return updateAtStr;
    }

    public void setUpdateAtStr(String updateAtStr) {
        this.updateAtStr = updateAtStr;
    }

    public String getCreatedAtStr() {
        return createdAtStr;
    }

    public void setCreatedAtStr(String createdAtStr) {
        this.createdAtStr = createdAtStr;
    }

    public int getRecommendSort() {
        return recommendSort;
    }

    public void setRecommendSort(int recommendSort) {
        this.recommendSort = recommendSort;
    }

    public String getShelvesNo() {
        return shelvesNo;
    }

    public void setShelvesNo(String shelvesNo) {
        this.shelvesNo = shelvesNo;
    }

    public String getVolumetric() {
        return volumetric;
    }

    public void setVolumetric(String volumetric) {
        this.volumetric = volumetric;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
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
