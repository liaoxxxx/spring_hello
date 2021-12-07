package com.liaoxx.spring_hello.dto.api.common;

import com.liaoxx.spring_hello.dto.DtoI;
import com.liaoxx.spring_hello.entity.system.SystemShopConfig;

public class MallConfigDto implements DtoI {


    public boolean isExamine;
    public String mpIsExamine;

    public int invitationRegister;

    public SystemShopConfig system;

    @Override
    public boolean isDto() {
        return true;
    }
}
