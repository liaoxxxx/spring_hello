package com.liaoxx.spring_hello.constants;

public class CommonStateEnum {
    public static final int StateOK               = 2; // 正常
    public static final int StateWait             = 1; // 等待    | 订单中： 已付款待发货
    public static final int StateNo               = 0; // 无状态
    public static final int StateRemove           = 4; // 已经删除
    public static final int StateWaitT            = 3; // 已经确认等待  | 订单中： 已发货
    public static final int StateWaitUserRemove   = 6; // 用户取消
    public static final int StateWaitSystemRemove = 5; // 系统取消
    public static final int StateCommonExpired    = 3; //过期 |专场 ，优惠券 等
}
