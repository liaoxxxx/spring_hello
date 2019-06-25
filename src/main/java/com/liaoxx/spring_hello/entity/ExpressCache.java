package com.liaoxx.spring_hello.entity;
import javax.persistence.*;

@Entity     //标注为实体类
@Table(name="express_query_cache")      //标注表名为"express_query_cache";
public class ExpressCache {
    @Id //标注为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //标注为自增主键
    private int  id;
    @Column         //标注为字段
    private String expressProviderName;
    @Column
    private String expressProviderCode;

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    @Column
    private String expressNo;
    @Column
    private  String datas;
    @Column
    private  long expireAt;
    @Column
    private long created_at;
    @Column
    private long updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpressProviderName() {
        return expressProviderName;
    }

    public void setExpressProviderName(String expressProviderName) {
        this.expressProviderName = expressProviderName;
    }

    public String getExpressProviderCode() {
        return expressProviderCode;
    }

    public void setExpressProviderCode(String expressProviderCode) {
        this.expressProviderCode = expressProviderCode;
    }
    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }
    public long getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(long expireAt) {
        this.expireAt = expireAt;
    }

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }
    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public long  getUpdated_at() {
        return updated_at;
    }


}
