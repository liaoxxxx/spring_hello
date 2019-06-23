package com.liaoxx.spring_hello.entity;
import javax.persistence.*;

@Entity     //标注为实体类
@Table(name="express_provider")      //标注表名为"admin";
public class ExpressProvider {
    @Id //标注为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //标注为自增主键
    private int  id;
    @Column         //标注为字段
    private String expressProviderName;
    @Column
    private String expressProviderCode;
    @Column
    private String expressProviderChar;
    @Column
    private String expressProviderCustomerName;
    @Column
    private byte is_delete;
    @Column
    private String remark;
    @Column
    private byte status;
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

    public String getExpressProviderChar() {
        return expressProviderChar;
    }

    public void setExpressProviderChar(String expressProviderChar) {
        this.expressProviderChar = expressProviderChar;
    }

    public byte getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(byte is_delete) {
        this.is_delete = is_delete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
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

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }
    public String getExpressProviderCustomerName() {
        return expressProviderCustomerName;
    }

    public void setExpressProviderCustomerName(String expressProviderCustomerName) {
        this.expressProviderCustomerName = expressProviderCustomerName;
    }
}
