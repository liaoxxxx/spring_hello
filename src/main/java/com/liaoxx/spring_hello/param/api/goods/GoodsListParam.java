package com.liaoxx.spring_hello.param.api.goods;

import com.liaoxx.spring_hello.util.Pagination;


public class GoodsListParam {
    public int page = Pagination.pageDefault;

    public int pagesize=Pagination.limitDefault;
}
