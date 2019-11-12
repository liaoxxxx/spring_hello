package com.liaoxx.spring_hello.util;

import java.util.HashMap;
import java.util.Map;

public class JsonResponse {



    private Map<String,Object> respMap(){
        return new HashMap<String,Object>();
    }


    public Map<String,Object> jsonSuccess(String msg,Object data ){
        Map<String,Object> map=this.respMap();
        map.put("code",200);
        map.put("success","success");
        map.put("message",msg);
        map.put("data",data);
        return  map;
    }

    public Map<String,Object> jsonError(String msg,Object data ){
        Map<String,Object> map=this.respMap();
        map.put("code",500);
        map.put("success","error");
        map.put("message",msg);
        map.put("data",data);
        return  map;
    }
}
