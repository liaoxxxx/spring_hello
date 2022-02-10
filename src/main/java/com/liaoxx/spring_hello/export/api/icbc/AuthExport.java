package com.liaoxx.spring_hello.export.api.icbc;

import com.liaoxx.spring_hello.entity.goods.Goods;
import com.liaoxx.spring_hello.entity.goods.GoodsOptionDto;
import com.liaoxx.spring_hello.entity.goods.GoodsSpec;
import com.liaoxx.spring_hello.entity.goods.GoodsSpecItem;
import com.liaoxx.spring_hello.export.ExportI;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

public class AuthExport implements ExportI {

    public AuthExport(String decodeJson) {

        this.decodeJson=decodeJson;
    }

    @Getter
    private final String decodeJson;

    @Override
    public void isDto() {}
}
