package com.liaoxx.spring_hello.export.api.common;

import com.liaoxx.spring_hello.export.ExportI;
import com.liaoxx.spring_hello.entity.common.CommonAd;

import java.util.ArrayList;
import java.util.List;

public class CommonAdListExport implements ExportI {
    public long count=0;

    public int page=0;

    public int pagesize=0;

    public List<CommonAd> list=new ArrayList<>();

    @Override
    public void isDto() {}
}
