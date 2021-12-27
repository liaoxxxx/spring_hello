package com.liaoxx.spring_hello.export.api.common;

import com.liaoxx.spring_hello.export.ExportI;
import com.liaoxx.spring_hello.entity.goods.Goods;
import com.liaoxx.spring_hello.entity.goods.GoodsSpecial;
import com.liaoxx.spring_hello.entity.goods.GoodsSuit;
import com.liaoxx.spring_hello.entity.common.CommonAd;
import com.liaoxx.spring_hello.entity.common.CommonBanner;
import com.liaoxx.spring_hello.entity.common.CommonNav;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class PageBasicsExport implements ExportI {

    @Getter
    @Setter
    private List<CommonBanner> banner;

    @Getter
    @Setter
    private List<CommonAd> ad;

    @Getter
    @Setter
    private List<CommonNav> nav;

    @Getter
    @Setter
    private List<Goods> ishot;

    @Getter
    @Setter
    private List<GoodsSpecial> spacial;

    @Getter
    @Setter
    private List<GoodsSuit> suit;


    @Override
    public void isDto() {}
}
