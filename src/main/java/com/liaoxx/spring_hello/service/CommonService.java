package com.liaoxx.spring_hello.service;

import com.liaoxx.spring_hello.constants.PlugEnum;
import com.liaoxx.spring_hello.constants.SystemEnum;
import com.liaoxx.spring_hello.dto.api.common.MallConfigDto;
import com.liaoxx.spring_hello.entity.plug.Plug;
import com.liaoxx.spring_hello.entity.system.SystemShopConfig;
import com.liaoxx.spring_hello.entity.system.SystemWeixinMpA;
import com.liaoxx.spring_hello.repository.SystemRepository;
import com.liaoxx.spring_hello.service.plug.PlugService;
import com.liaoxx.spring_hello.util.request.HttpRequestUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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




}
