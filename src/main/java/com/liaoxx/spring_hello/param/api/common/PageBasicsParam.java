package com.liaoxx.spring_hello.param.api.common;


import lombok.Getter;
import lombok.Setter;

public class PageBasicsParam {

    @Getter
    @Setter
    private String position;  //显示的位置

    @Getter
    @Setter
    private int  withSpecialGoods;  //是否关联专场的商品


}
