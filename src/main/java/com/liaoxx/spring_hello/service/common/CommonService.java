package com.liaoxx.spring_hello.service.common;

import com.liaoxx.spring_hello.constants.*;
import com.liaoxx.spring_hello.dto.api.common.MallConfigDto;
import com.liaoxx.spring_hello.dto.api.common.PageBasicsDto;
import com.liaoxx.spring_hello.entity.goods.Goods;
import com.liaoxx.spring_hello.entity.goods.GoodsSpecial;
import com.liaoxx.spring_hello.entity.common.CommonAd;
import com.liaoxx.spring_hello.entity.common.CommonBanner;
import com.liaoxx.spring_hello.entity.common.CommonNav;
import com.liaoxx.spring_hello.entity.goods.GoodsSuit;
import com.liaoxx.spring_hello.entity.plug.Plug;
import com.liaoxx.spring_hello.entity.system.SystemWeixinMpA;
import com.liaoxx.spring_hello.param.api.common.PageBasicsParam;
import com.liaoxx.spring_hello.service.SystemService;
import com.liaoxx.spring_hello.service.goods.GoodsService;
import com.liaoxx.spring_hello.service.goods.GoodsSpecialService;
import com.liaoxx.spring_hello.service.goods.GoodsSuitService;
import com.liaoxx.spring_hello.service.plug.PlugService;
import com.liaoxx.spring_hello.util.SpecUtil;
import com.liaoxx.spring_hello.util.DateTool;
import com.liaoxx.spring_hello.util.request.HttpRequestUtil;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommonService {
    @Resource
    SystemService systemService;

    @Resource
    CommonAdService adService;

    @Resource
    CommonNavService navService;


    @Resource
    PlugService plugService;


    @Resource
    CommonBannerService commonBannerSvc;

    @Resource
    GoodsSpecialService specialService;

    @Resource
    GoodsSuitService suitService;

    @Resource
    GoodsService goodsService;


    public MallConfigDto commonConfig(String wxV) {
        MallConfigDto mallConfigDto = new MallConfigDto();
        Plug invitationPlug = plugService.getByKey(PlugEnum.FUNC_INVITATION);
        mallConfigDto.invitationRegister = invitationPlug.getState();

        SystemWeixinMpA sysWxMpACfg = systemService.getConfigByKey(SystemEnum.SYSTEM_WEIXIN_MP, SystemWeixinMpA.class);
        mallConfigDto.mp = sysWxMpACfg.examine;

        //是否在审核中
        boolean isExamine = wxV.equals(sysWxMpACfg.getExamine());
        mallConfigDto.mpIsExamine = isExamine;
        mallConfigDto.system = systemService.getSystemShopConfig();

        return mallConfigDto;
    }

    public PageBasicsDto getPageBasics(HttpServletRequest request, PageBasicsParam pageBasicsParam) {
        PageBasicsDto pageBasicsDto = new PageBasicsDto();
        String position = pageBasicsParam.getPosition();
        String platform = HttpRequestUtil.getHeader(request,"platform");
        int withSpecialGoods = pageBasicsParam.getWithSpecialGoods();

        ArrayList<GoodsSpecial> specialListTmp = new ArrayList<GoodsSpecial>();

        if (pageBasicsParam.getWithSpecialGoods() == 1) {
            withSpecialGoods = pageBasicsParam.getWithSpecialGoods();
        }
        long nowSecond = DateTool.getTimestamp();

        //banner轮播图查询
        Specification<CommonBanner> bannerSearch = SpecUtil.lt("ctime", nowSecond)
                .and(SpecUtil.gt("etime", nowSecond))
                .and(SpecUtil.eq("state", MainState.StateOK));
        if (position != null && !position.equals("")) {
            bannerSearch = bannerSearch.and(SpecUtil.eq("position", position));
        }
        if (platform != null && !platform.equals("")) {
            bannerSearch = bannerSearch.and(SpecUtil.eq("platform", platform));
        }
        List<CommonBanner> bannerList = commonBannerSvc.List(bannerSearch);

        //广告查询
        Specification<CommonAd> adSearch = SpecUtil.lt("ctime", nowSecond)
                .and(SpecUtil.gt("etime", nowSecond))
                .and(SpecUtil.eq("state", MainState.StateOK));
        if (position != null && !position.equals("")) {
            adSearch = adSearch.and(SpecUtil.eq("position", position));
        }
        if (platform != null && !platform.equals("")) {
            adSearch = adSearch.and(SpecUtil.eq("platform", platform));
        }
        List<CommonAd> adList = adService.list(adSearch);

        //导航查询
        Specification<CommonNav> navSearch = SpecUtil.eq("position", position).and(SpecUtil.eq("state", MainState.StateOK));
        if (platform != null && !platform.equals("")) {
            navSearch = navSearch.and(SpecUtil.eq("platform", platform));
        }
        List<CommonNav> navList = navService.List(navSearch);


        ////获取专场信息
        Specification<GoodsSpecial> specSearch = SpecUtil.eq("position", position).and(SpecUtil.eq("state", MainState.StateOK));
        List<GoodsSpecial> specList = specialService.list(specSearch);

        //    if withSpecialGoods == int64(model.StateOK) { //需要获取专场商品  todo
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


        //获取套装购信息
        Specification<GoodsSuit> suitSearch = SpecUtil.gt("etime", nowSecond)
                .and(SpecUtil.eq("state", MainState.StateOK));
        if (position != null && !position.equals("")) {
            suitSearch = suitSearch.and(SpecUtil.eq("position", position));
        }
        List<GoodsSuit> suitList = suitService.list(suitSearch);

        ////获取热门商品
        // Specification<Goods> goodsSearch = SpecUtil.eq("is_hot", MainState.StateOK).and(SpecUtil.eq("state", MainState.StateOK));
        Specification<Goods> goodsHotSearch = SpecUtil.eq("state", MainState.StateOK).and(SpecUtil.eq("isHot", MainState.StateOK));
        List<Goods>   hotGoodsList= goodsService.list(goodsHotSearch);
        //ishot, _, err := rpc.Goods.RPC_Get_GoodsGetList(map[string]interface{}{"is_hot": model.StateOK, "brand_id": c.FormValue("brand_id")}, int64(0), int64(50), util.Int64s(c.Get("uid")), c)
        //if suit != nil && err == nil {
        //    _Rs["ishot"] = ishot
        //}
        //return c.JSON(open.SuccJson(c, _Rs))
        if (adList != null) {
            pageBasicsDto.setAd(adList);
        }
        if (bannerList != null) {
            pageBasicsDto.setBanner(bannerList);
        }
        if (navList != null) {
            pageBasicsDto.setNav(navList);
        }
        if (specList != null) {
            pageBasicsDto.setSpacial(specList);
        }
        if (suitList != null) {
            pageBasicsDto.setSuit(suitList);
        }
        if (hotGoodsList != null) {
            pageBasicsDto.setIshot(hotGoodsList);
        }

        return pageBasicsDto;
    }


}
