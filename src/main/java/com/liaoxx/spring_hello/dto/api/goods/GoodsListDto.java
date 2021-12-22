package com.liaoxx.spring_hello.dto.api.goods;

import com.liaoxx.spring_hello.dto.DtoI;
import com.liaoxx.spring_hello.entity.goods.Goods;

import java.util.ArrayList;
import java.util.List;

public class GoodsListDto implements DtoI {
    public long count=0;

    public int page=0;

    public int pagesize=0;

    public List<Goods> list=new ArrayList<>();

    @Override
    public void isDto() {}
}
