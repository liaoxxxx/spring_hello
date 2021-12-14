package com.liaoxx.spring_hello.service.common;

import com.liaoxx.spring_hello.constants.*;
import com.liaoxx.spring_hello.dto.api.common.MallConfigDto;
import com.liaoxx.spring_hello.dto.api.common.PageBasicsDto;
import com.liaoxx.spring_hello.entity.GoodsSpecial;
import com.liaoxx.spring_hello.entity.common.CommonAd;
import com.liaoxx.spring_hello.entity.common.CommonBanner;
import com.liaoxx.spring_hello.entity.plug.Plug;
import com.liaoxx.spring_hello.entity.system.SystemWeixinMpA;
import com.liaoxx.spring_hello.param.api.common.PageBasicsParam;
import com.liaoxx.spring_hello.service.SystemService;
import com.liaoxx.spring_hello.service.plug.PlugService;
import com.liaoxx.spring_hello.util.SpecUtil;
import com.liaoxx.spring_hello.util.DateTool;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommonService {
    @Resource
    SystemService systemService;

    @Resource
    CommonAdService adService;


    @Resource
    PlugService plugService;


    @Resource
    CommonBannerService commonBannerSvc;

    public MallConfigDto commonConfig(String wxV) {
        MallConfigDto mallConfigDto=  new MallConfigDto();
        Plug invitationPlug=plugService.getByKey(PlugEnum.FUNC_INVITATION);
        mallConfigDto.invitationRegister=invitationPlug.getState();

        SystemWeixinMpA sysWxMpACfg=systemService.getConfigByKey(SystemEnum.SYSTEM_WEIXIN_MP,SystemWeixinMpA.class);
        mallConfigDto.mp=sysWxMpACfg.examine;

        //是否在审核中
        boolean isExamine = wxV.equals(sysWxMpACfg.getExamine());
        mallConfigDto.mpIsExamine=isExamine;
        mallConfigDto.system=systemService.getSystemShopConfig();

        return mallConfigDto;
    }

    public PageBasicsDto getPageBasics(PageBasicsParam pageBasicsParam) {
        PageBasicsDto pageBasicsDto=  new PageBasicsDto();
        String position  = pageBasicsParam.getPosition();
        String platform  = pageBasicsParam.getPlatform();
        int withSpecialGoods = pageBasicsParam.getWithSpecialGoods();;
        ArrayList<GoodsSpecial> specialListTmp = new ArrayList<GoodsSpecial>();

        if (pageBasicsParam.getWithSpecialGoods() == 1) {
            withSpecialGoods = pageBasicsParam.getWithSpecialGoods();
        }
        long nowSecond= DateTool.getTimestamp();

        //banner轮播图查询
        Specification<CommonBanner> bannerSearch = SpecUtil.lt("ctime",nowSecond )
                .and(SpecUtil.gt("etime", nowSecond))
                .and(SpecUtil.eq("state", MainState.StateOK));
        if (position!=null&&!position.equals("")) {bannerSearch=  bannerSearch.and(SpecUtil.eq("position", position));}
        if (platform!=null&&!platform.equals("")) {bannerSearch= bannerSearch.and(SpecUtil.eq("platform", platform));}
        List<CommonBanner> bannerList= commonBannerSvc.List(bannerSearch);

        //广告查询
        Specification<CommonAd> adSearch = SpecUtil.lt("ctime",nowSecond )
                .and(SpecUtil.gt("etime", nowSecond))
                .and(SpecUtil.eq("state", MainState.StateOK));
        if (position!=null&&!position.equals("")) {adSearch=  adSearch.and(SpecUtil.eq("position", position));}
        if (platform!=null&&!platform.equals("")) {adSearch= adSearch.and(SpecUtil.eq("platform", platform));}
       List<CommonAd> adList = adService.List(adSearch);

       ////这边是没有时间的
       //nav, err := rpc.Common.RPC_Get_NavList(util.Search(map[string]interface{}{
       //    "platform": c.Get("platform"),
       //            "state":    model.StateOK,
       //            "position": position,
       //}))
       ////热门
       //if err == nil && nav != nil {
       //    _Rs["nav"] = nav
       //}
       ////获取专场信息
       //special_order := util.Search(map[string]interface{}{
       //    "state":    model.StateOK,
       //            "etime|>=": time.Now().Unix(),
       //})
       //if position == model.PAGEPOSTION {
       //    special_order["is_recommand"] = model.StateOK
       //} else {
       //    special_order["position"] = position
       //}
       //specialList, err := rpc.Goods.RPC_Get_GoodsSpecialList(special_order)
       //if specialList != nil && err == nil {
       //    for _, special := range specialList {
       //        specialTmp := special
       //                specialListTmp = append(specialListTmp, *specialTmp)
       //    }
       //    if withSpecialGoods == int64(model.StateOK) { //需要获取专场商品
       //        for i, special := range specialListTmp {
       //            specialTmp := special
       //            specialGoodsList, _, err := specialInfo.GoodsSpecialGoodsListBrief(map[string]interface{}{"state": model.StateOK, "special_id": specialTmp.Id},
       //            1, 10, "r DESC", c)
       //            if err == nil && len(specialGoodsList) > 0 {
       //                specialTmp.SpecialGoodsList = specialGoodsList
       //            }
       //            specialListTmp[i] = specialTmp
       //        }
       //    }
       //    _Rs["special"] = specialListTmp
       //}
       ////获取套够信息
       //suit_order := util.Search(map[string]interface{}{
       //    "state":    model.StateOK,
       //            "etime|>=": time.Now().Unix(),
       //})
       //if position == model.PAGEPOSTION {
       //    suit_order["is_recommand"] = model.StateOK
       //} else {
       //    suit_order["position"] = position
       //}
       //suit, err := rpc.Goods.RPC_Get_GoodsSuitList(suit_order)
       //if suit != nil && err == nil {
       //    _Rs["suit"] = suit
       //}
       ////获取热门商品
       //ishot, _, err := rpc.Goods.RPC_Get_GoodsGetList(map[string]interface{}{"is_hot": model.StateOK, "brand_id": c.FormValue("brand_id")}, int64(0), int64(50), util.Int64s(c.Get("uid")), c)
       //if suit != nil && err == nil {
       //    _Rs["ishot"] = ishot
       //}
       //return c.JSON(open.SuccJson(c, _Rs))
        if (adList != null ){
            pageBasicsDto.setAd(adList);
        }
        if (bannerList != null ){
            pageBasicsDto.setBanner(bannerList);
        }
        return pageBasicsDto;
    }



}
