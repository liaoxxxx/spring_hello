package com.liaoxx.spring_hello.entity.system;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

public class SystemShopConfig {

    @Getter
    @Setter
    @JSONField(name = "private_domain",deserialize = false)
    private int privateDomain;

    @JSONField(name = "c_domain",deserialize = false)
    private String cDomain;

    @JSONField(name = "b_domain",deserialize = false)
    private String bDomain;

    @JSONField(name = "is_zgbury",deserialize = false)
    private int isZgbury;

    @JSONField(name = "is_renlian",deserialize = false)
    private int isRenlian;



}
