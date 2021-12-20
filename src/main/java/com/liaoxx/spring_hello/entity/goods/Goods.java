package com.liaoxx.spring_hello.entity.goods;



import com.liaoxx.spring_hello.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "goods")
public class Goods {
    @Id //标注为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //标注为自增主键
    private int id;

    @NotBlank(message = "商品的标题不能为空")
    @Column
    private String title;

    @Column
    private String thumb;  // 缩略图

    @NotNull
    @Column
    private Date createdAt;

    @Column
    @NotNull
    private Date updatedAt;

    @Column
    @NotNull
    private int isNew;


    @Column(name = "is_hot", nullable = false)
    @NotNull
    private int isHot;

    private Integer state;

    private String content;

    private String description;

    private String productsn;

    private String goodssn;

    private BigDecimal marketprice;

    private BigDecimal costprice;

    private BigDecimal productprice;

    private Integer virtualSales;

    private Integer sales;

    private String thumbs;

    private Integer pcate;

    private Integer cate;

    private Integer tcate;

    private Integer brandId;

    private Integer isSpec;

    private Integer stock;

    private Integer r;

    private String sourceId;

    private String sourceName;

    private Integer isRecommand;

    private String supplierName;

    private Integer ty;

    private BigDecimal supplyCostprice;

    private BigDecimal freight;

    @Column(name = "freight", precision = 10, scale = 2)
    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    @Column(name = "supply_costprice", nullable = false, precision = 10, scale = 2)
    public BigDecimal getSupplyCostprice() {
        return supplyCostprice;
    }

    public void setSupplyCostprice(BigDecimal supplyCostprice) {
        this.supplyCostprice = supplyCostprice;
    }

    @Column(name = "ty", nullable = false)
    public Integer getTy() {
        return ty;
    }

    public void setTy(Integer ty) {
        this.ty = ty;
    }

    @Column(name = "supplier_name", nullable = false, length = 100)
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Column(name = "is_recommand", nullable = false)
    public Integer getIsRecommand() {
        return isRecommand;
    }

    public void setIsRecommand(Integer isRecommand) {
        this.isRecommand = isRecommand;
    }

    @Column(name = "source_name", nullable = false, length = 100)
    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    @Column(name = "source_id", nullable = false, length = 100)
    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    @Column(name = "r", nullable = false)
    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    @Column(name = "stock", nullable = false)
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Column(name = "is_spec", nullable = false)
    public Integer getIsSpec() {
        return isSpec;
    }

    public void setIsSpec(Integer isSpec) {
        this.isSpec = isSpec;
    }

    @Column(name = "brand_id", nullable = false)
    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @Column(name = "tcate", nullable = false)
    public Integer getTcate() {
        return tcate;
    }

    public void setTcate(Integer tcate) {
        this.tcate = tcate;
    }

    @Column(name = "cate", nullable = false)
    public Integer getCate() {
        return cate;
    }

    public void setCate(Integer cate) {
        this.cate = cate;
    }

    @Column(name = "pcate", nullable = false)
    public Integer getPcate() {
        return pcate;
    }

    public void setPcate(Integer pcate) {
        this.pcate = pcate;
    }

    @Lob
    @Column(name = "thumbs", nullable = false)
    public String getThumbs() {
        return thumbs;
    }

    public void setThumbs(String thumbs) {
        this.thumbs = thumbs;
    }

    @Column(name = "sales", nullable = false)
    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    @Column(name = "virtual_sales")
    public Integer getVirtualSales() {
        return virtualSales;
    }

    public void setVirtualSales(Integer virtualSales) {
        this.virtualSales = virtualSales;
    }

    @Column(name = "productprice", nullable = false, precision = 10, scale = 2)
    public BigDecimal getProductprice() {
        return productprice;
    }

    public void setProductprice(BigDecimal productprice) {
        this.productprice = productprice;
    }

    @Column(name = "costprice", nullable = false, precision = 10, scale = 2)
    public BigDecimal getCostprice() {
        return costprice;
    }

    public void setCostprice(BigDecimal costprice) {
        this.costprice = costprice;
    }

    @Column(name = "marketprice", nullable = false, precision = 10, scale = 2)
    public BigDecimal getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(BigDecimal marketprice) {
        this.marketprice = marketprice;
    }

    @Column(name = "goodssn", nullable = false, length = 100)
    public String getGoodssn() {
        return goodssn;
    }

    public void setGoodssn(String goodssn) {
        this.goodssn = goodssn;
    }

    @Column(name = "productsn", nullable = false, length = 100)
    public String getProductsn() {
        return productsn;
    }

    public void setProductsn(String productsn) {
        this.productsn = productsn;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Lob
    @Column(name = "content", nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "state", nullable = false)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }


}
