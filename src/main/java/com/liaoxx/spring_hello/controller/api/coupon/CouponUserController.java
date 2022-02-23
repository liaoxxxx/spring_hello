package com.liaoxx.spring_hello.controller.api.coupon;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONObject;
import com.liaoxx.spring_hello.entity.coupon.CouponUserDto;
import com.liaoxx.spring_hello.exception.ServiceException;
import com.liaoxx.spring_hello.export.api.coupon.CouponUserExport;
import com.liaoxx.spring_hello.export.api.goods.GoodsDetailExport;
import com.liaoxx.spring_hello.export.api.goods.GoodsListExport;
import com.liaoxx.spring_hello.param.api.ApiParamMap;
import com.liaoxx.spring_hello.param.api.goods.GoodsListParam;
import com.liaoxx.spring_hello.param.api.order.OrderSkuParams;
import com.liaoxx.spring_hello.service.goods.GoodsService;
import com.liaoxx.spring_hello.util.response.JsonResp;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
@RestController
@RequestMapping("/xx/coupon")
public class CouponUserController {

    @Resource
    GoodsService goodsService;

    @PostMapping(value = "/sure/list")
    public JsonResp list(HttpServletRequest request, GoodsListParam goodsListParam) {
        CouponUserExport export = new CouponUserExport();
        CouponUserDto dto = new CouponUserDto();
        List<OrderSkuParams> params;
        String paramJson = request.getParameter("list");
        Map parameterMap = request.getParameterMap();
        System.out.println("----------parameterMap----------");
        System.out.println("p");
        System.out.println("----------parameterMap----------");
        params = JSONObject.parseArray(paramJson, OrderSkuParams.class);

        if (params.size() == 0) {
            return JsonResp.Success(export);
        }
        //未找到 相应的可用优惠券
       //item, _, err :=rpc.Order.RPC_Get_OrderGoodsParams(params, util.Int64s(c.Get("uid")), c)
       //coupon, err :=CouponGetList(util.Int64s(c.Get("uid")), map[string] interface {
       //}
       //{
       //    "uid":util.Int64s(c.Get("uid")),
       //        "state":model.StateWait,
       //        "etime|>=":time.Now().Unix(),
       //})
       //items:= []*model.CouponUser {
       //}
       //for _, v :=range coupon {
       //    //品牌
       //    t:= &model.CouponUser {
       //    }
       //    t = v
       //    if v.Resource == model.CouponTyBrand {
       //        price:=float64(0)
       //        for _, vv :=range item {
       //            if vv.GoodsOption.Brand_id == v.Resource_id {
       //                price += vv.Price
       //            }
       //        }
       //        if
       //        len(item) != 0 && price >= float64(v.Full_price) && time.Now().Unix() > v.Ctime && v.Etime > time.Now().Unix() && v.State == model.StateWait
       //        {
       //            items = append(items, t)
       //        }
       //    }
       //    //全场折
       //    if v.Resource == model.CouponTy {
       //        price:=float64(0)
       //        var(
       //                iids[]int64
	//	)
       //        ids:=strings.Split(v.Ids, ",")
       //        for _, v :=range ids {
       //            iids = append(iids, util.Int64s(v))
       //        }
       //        for _, vv :=range item {
       //            is:=util.InArray(vv.Goods_id, iids)
       //            if is {
       //                continue
       //            }
       //            price += vv.Price
       //        }
       //        if
       //        len(item) != 0 && price >= float64(v.Full_price) && time.Now().Unix() > v.Ctime && v.Etime > time.Now().Unix() && v.State == model.StateWait
       //        {
       //            items = append(items, t)
       //        }
       //    }
       //    //专场
       //    if v.Resource == model.CouponTySpecial {
       //        price:=float64(0)
       //        for _, vv :=range item {
       //            if vv.Source_id == v.Resource_id {
       //                price += vv.Price
       //            }
       //        }
       //        if
       //        len(item) != 0 && price >= float64(v.Full_price) && time.Now().Unix() > v.Ctime && v.Etime > time.Now().Unix() && v.State == model.StateWait
       //        {
       //            items = append(items, t)
       //        }
       //    }
       //}
        return JsonResp.Success(export);

    }


    @GetMapping(value = "/detail")
    public JsonResp detail(HttpServletRequest request) throws ServiceException {
        ApiParamMap paramMap = new ApiParamMap(request.getParameterMap());
        int goodsId = Integer.parseInt(paramMap.paramMap.get("id")[0]);
        GoodsDetailExport detailDto = goodsService.detail(goodsId);
        return JsonResp.Success(detailDto);
    }


}
