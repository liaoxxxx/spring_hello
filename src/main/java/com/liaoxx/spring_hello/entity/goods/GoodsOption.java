package com.liaoxx.spring_hello.entity.goods;

import com.liaoxx.spring_hello.entity.EntityI;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity(name = "Goods_Option")
@Table(name = "goods_option")
public class GoodsOption  implements EntityI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Integer goods_id;

    private String title;

    private String thumb;

    private BigDecimal productprice;

    private BigDecimal marketprice;

    private BigDecimal costprice;

    private Integer stock;

    private BigDecimal weight;

    private Integer r;

    private String specs;

    private String goodssn;

    private String productsn;

    private String source_id;

    private String source_name;

    private Integer state;

    private Instant updated_at;

    private Instant created_at;

    private Integer stock_lock;

    private Integer source_stock;

    private BigDecimal supply_costprice;

    @Column(name = "supply_costprice", nullable = false, precision = 10, scale = 2)
    public BigDecimal getSupply_costprice() {
        return supply_costprice;
    }

    public void setSupply_costprice(BigDecimal supplyCostprice) {
        this.supply_costprice = supplyCostprice;
    }

    @Column(name = "source_stock", nullable = false)
    public Integer getSource_stock() {
        return source_stock;
    }

    public void setSource_stock(Integer source_stock) {
        this.source_stock = source_stock;
    }

    @Column(name = "stock_lock", nullable = false)
    public Integer getStock_lock() {
        return stock_lock;
    }

    public void setStock_lock(Integer stock_lock) {
        this.stock_lock = stock_lock;
    }

    @Column(name = "created_at", nullable = false)
    public Instant getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    @Column(name = "updated_at", nullable = false)
    public Instant getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Instant updated_at) {
        this.updated_at = updated_at;
    }

    @Column(name = "state", nullable = false)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Column(name = "source_name", nullable = false, length = 100)
    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    @Column(name = "source_id", nullable = false, length = 100)
    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    @Column(name = "productsn", nullable = false)
    public String getProductsn() {
        return productsn;
    }

    public void setProductsn(String productsn) {
        this.productsn = productsn;
    }

    @Column(name = "goodssn", nullable = false)
    public String getGoodssn() {
        return goodssn;
    }

    public void setGoodssn(String goodssn) {
        this.goodssn = goodssn;
    }

    @Column(name = "specs", nullable = false)
    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    @Column(name = "r", nullable = false)
    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    @Column(name = "weight", nullable = false, precision = 10, scale = 2)
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Column(name = "stock", nullable = false)
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

    @Column(name = "productprice", nullable = false, precision = 10, scale = 2)
    public BigDecimal getProductprice() {
        return productprice;
    }

    public void setProductprice(BigDecimal productprice) {
        this.productprice = productprice;
    }

    @Column(name = "thumb", nullable = false)
    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    @Column(name = "title", nullable = false, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "goods_id", nullable = false)
    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}