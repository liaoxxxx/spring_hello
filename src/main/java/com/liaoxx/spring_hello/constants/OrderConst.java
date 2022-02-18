package com.liaoxx.spring_hello.constants;

import org.hibernate.type.OrderedMapType;

public class OrderConst {
   public static final byte OrderTy        = 0;//普通商品
   public static final byte OrderTySpecial = 3;//专场商品
   public static final byte OrderTySpell   = 5;//拼图
   public static final byte OrderTySuit    = 4;//套装购
   public static final byte OrderTySeckill = 60;//普通秒杀
   public static final byte OrderTySign    = 70;//普通签到兑换
}
