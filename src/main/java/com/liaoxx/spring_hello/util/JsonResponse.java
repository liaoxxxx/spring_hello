package com.liaoxx.spring_hello.util;

import java.util.HashMap;
import java.util.Map;

public class JsonResponse {



    private static Map<String,Object> respMap(){
        return new HashMap<String,Object>();
    }


    public static Map<String,Object> jsonSuccess(String msg,Object data ){
        Map<String,Object> map=respMap();
        map.put("code",200);
        map.put("success","success");
        map.put("message",msg);
        map.put("data",data);
        return  map;
    }

    public static Map<String,Object> jsonError(String msg,Object data ){
        Map<String,Object> map=respMap();
        map.put("code",500);
        map.put("success","error");
        map.put("message",msg);
        map.put("data",data);
        return  map;
    }
}
