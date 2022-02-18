package com.liaoxx.spring_hello.param.api.order;

import com.liaoxx.spring_hello.entity.goods.Goods;
import com.liaoxx.spring_hello.entity.goods.GoodsOption;
import com.liaoxx.spring_hello.entity.goods.GoodsOptionDto;

public class OrderSkuParams {

    public int source_id;            //场ID
    public String source_name;           //外部供应源
    public int resource_id;             //额外的ID
    public byte ty;                  //场类型
    public int number;             //数量
    public int option_id;             //Option id
    public int goods_id;               //商品ID
    public double price;               //商品最终支付价格
    public double discount_price;        //优惠价格
    public double commission_price;       //第一分销金额
    public double second_commission_price; //二级分销金额
    public double costprice;              //商品单价
    public int cart_id;       //购物车
    public int session_id;             // 秒杀goods_seckill.id| 套装 |  场次id
    public Goods goods;                 //商品数据
    public GoodsOptionDto goods_option;       //商品sku数据


}
