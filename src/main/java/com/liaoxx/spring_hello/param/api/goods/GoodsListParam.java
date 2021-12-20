package com.liaoxx.spring_hello.param.api.goods;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.liaoxx.spring_hello.constants.MainState;
import com.liaoxx.spring_hello.util.Pagination;

import javax.annotation.Nullable;


public class GoodsListParam {
    @JsonProperty(value = "page")
    public int page = Pagination.pageDefault;
    @JsonProperty(value = "pagesize")
    public int pagesize=Pagination.limitDefault;

    public int isHot= MainState.StateOK;

    public int isNew=MainState.StateOK;

    public String title;


    public int pcate;

    public int cate;

    public int tcate;
}
