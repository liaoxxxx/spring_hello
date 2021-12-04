package com.liaoxx.spring_hello.param.api.user;

import com.liaoxx.spring_hello.param.BaseParamI;

public class LoginParamI implements BaseParamI {
    public String phone;
    public String password;

    public String mms;


    @Override
    public boolean formDataParam() {
        return true;
    }
}
