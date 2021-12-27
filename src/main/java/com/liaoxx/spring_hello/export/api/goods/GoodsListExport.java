package com.liaoxx.spring_hello.export.api.goods;

import com.liaoxx.spring_hello.export.ExportI;
import com.liaoxx.spring_hello.entity.goods.Goods;

import java.util.ArrayList;
import java.util.List;

public class GoodsListExport implements ExportI {
    public long count=0;

    public int page=0;

    public int pagesize=0;

    public List<Goods> list=new ArrayList<>();

    @Override
    public void isDto() {}
}
