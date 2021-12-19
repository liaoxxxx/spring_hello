package com.liaoxx.spring_hello.dto.api.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.liaoxx.spring_hello.dto.DtoI;
import com.liaoxx.spring_hello.entity.system.SystemShopConfig;

public class MallConfigDto implements DtoI {


    @JsonProperty("mp")
    public String mp;

    @JsonProperty("mp_is_examine")
    public boolean mpIsExamine;

    @JsonProperty("invitation_register")
    public int invitationRegister;

    @JsonProperty("system")
    public SystemShopConfig system;

    @Override
    public void isDto() {}
}
