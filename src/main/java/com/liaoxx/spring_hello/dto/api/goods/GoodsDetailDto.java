package com.liaoxx.spring_hello.dto.api.goods;

import com.liaoxx.spring_hello.dto.DtoI;
import com.liaoxx.spring_hello.entity.goods.Goods;
import com.liaoxx.spring_hello.entity.goods.GoodsOption;
import com.liaoxx.spring_hello.entity.goods.GoodsSpec;
import com.liaoxx.spring_hello.entity.goods.GoodsSpecItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GoodsDetailDto implements DtoI {
    public Optional<Goods> list;

    public List<GoodsOption> option;

    public List<GoodsSpec> spec;

    public List<GoodsSpecItem> spec_item;

    @Override
    public void isDto() {}
}
