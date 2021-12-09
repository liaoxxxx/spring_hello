package com.liaoxx.spring_hello.entity.system;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class SystemShopConfig implements Serializable {

    @Getter
    @Setter
    @JSONField(name = "private_domain")
    @JsonProperty("private_domain")
    public int privateDomain;

    @Getter
    @Setter
    @JSONField(name = "c_domain")
    @JsonProperty("c_domain")
    public String cDomain;

    @Getter
    @Setter
    @JSONField(name = "b_domain")
    @JsonProperty("b_domain")
    public String bDomain;

    @Getter
    @Setter
    @JSONField(name = "is_zgbury")
    @JsonProperty("is_zgbury")
    public int isZgbury;

    @Getter
    @Setter
    @JSONField(name = "is_renlian")
    @JsonProperty("is_renlian")
    public int isRenlian;



}
