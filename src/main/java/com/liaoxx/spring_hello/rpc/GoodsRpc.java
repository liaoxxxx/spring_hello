package com.liaoxx.spring_hello.rpc;

import com.liaoxx.spring_hello.entity.goods.GoodsBrand;
import com.liaoxx.spring_hello.entity.goods.GoodsOption;
import com.liaoxx.spring_hello.entity.goods.GoodsOptionDto;
import com.liaoxx.spring_hello.util.NativeQuery;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class GoodsRpc {

    @Resource
    NativeQuery nativeQuery;
    public  static GoodsOptionDto RPC_Get_GoodsOptionGet(Map<String,Object> where){

        return null;
    }
    public  static List<GoodsOption>  Get_GoodsOptionIn(){

        return null;
    }

    public  List<GoodsBrand> Get_BrandIn(List<Long> brandIds, Map<String,OrderRpc> where){
      List<GoodsBrand>  list=  new ArrayList<>();
      return  list;
    }
}
