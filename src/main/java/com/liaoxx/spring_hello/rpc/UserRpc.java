package com.liaoxx.spring_hello.rpc;

import com.liaoxx.spring_hello.component.PriceCalcComponent;
import com.liaoxx.spring_hello.component.UserPriceResult;
import com.liaoxx.spring_hello.entity.goods.GoodsBrand;
import com.liaoxx.spring_hello.entity.goods.GoodsOption;
import com.liaoxx.spring_hello.entity.goods.GoodsOptionDto;
import com.liaoxx.spring_hello.util.NativeQuery;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRpc {



    public static UserPriceResult Get_UserPrice(HttpServletRequest request, double costPrice, double productPrice, double marketPrice) {

        return PriceCalcComponent.userPrice( request,  costPrice,  productPrice,  marketPrice);
    }
}
