package com.liaoxx.spring_hello.export.api.goods;

import com.liaoxx.spring_hello.entity.goods.*;
import com.liaoxx.spring_hello.export.ExportI;

import java.util.List;
import java.util.Optional;

public class GoodsDetailExport implements ExportI {
    public Optional<Goods> list;

    public List<GoodsOptionDto> option;

    public List<GoodsSpec> spec;

    public List<GoodsSpecItem> spec_item;

    @Override
    public void isDto() {}
}
