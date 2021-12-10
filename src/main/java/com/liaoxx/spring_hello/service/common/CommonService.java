package com.liaoxx.spring_hello.service.common;

import com.liaoxx.spring_hello.constants.PagePositionEnum;
import com.liaoxx.spring_hello.constants.PlugEnum;
import com.liaoxx.spring_hello.constants.SystemEnum;
import com.liaoxx.spring_hello.dto.api.common.MallConfigDto;
import com.liaoxx.spring_hello.dto.api.common.PageBasicsDto;
import com.liaoxx.spring_hello.entity.GoodsSpecial;
import com.liaoxx.spring_hello.entity.plug.Plug;
import com.liaoxx.spring_hello.entity.system.SystemShopConfig;
import com.liaoxx.spring_hello.entity.system.SystemWeixinMpA;
import com.liaoxx.spring_hello.param.api.common.PageBasicsParam;
import com.liaoxx.spring_hello.repository.SystemRepository;
import com.liaoxx.spring_hello.service.SystemService;
import com.liaoxx.spring_hello.service.plug.PlugService;
import com.liaoxx.spring_hello.util.request.HttpRequestUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class CommonService {
    @Resource
    SystemService systemService;


    @Resource
    PlugService plugService;

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
        String position = PagePositionEnum.PAGEPOSTION;
        int withSpecialGoods = 0;
        ArrayList<GoodsSpecial> specialListTmp = new ArrayList<GoodsSpecial>();
        if (!pageBasicsParam.getPosition().equals("")   ){
            position = pageBasicsParam.getPosition();
        }
        if (pageBasicsParam.getWithSpecialGoods() == 1) {
            withSpecialGoods = pageBasicsParam.getWithSpecialGoods();
        }

        search := util.Search(map[string]interface{}{
            "platform": c.Get("platform"),
                    "position": position,
                    "state":    model.StateOK,
                    "ctime|<=": time.Now().Unix(),
                    "etime|>=": time.Now().Unix(),
        })
        banner, err := rpc.Common.RPC_Get_BannerList(search)
       //if err == nil && banner != nil {
       //    _Rs["banner"] = banner
       //}
       //ad, err := rpc.Common.RPC_Get_AdList(search)
       //if err == nil && ad != nil {
       //    _Rs["ad"] = ad
       //}
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
        return pageBasicsDto;
    }



}
