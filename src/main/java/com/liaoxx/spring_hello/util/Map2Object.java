package com.liaoxx.spring_hello.util;

import com.liaoxx.spring_hello.param.BaseParamI;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Map2Object {


    public static BaseParamI requestToObject(HttpServletRequest request,Class<BaseParamI>  param) throws ClassNotFoundException {
        Class<?> obj = Class.forName(param.getName());
        org.apache.commons.beanutils.BeanUtils.populate(obj, map);
        return obj;

    }
}
