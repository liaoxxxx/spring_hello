package com.liaoxx.spring_hello.util.response;

import java.util.HashMap;
import java.util.Map;

public class JsonResp {

    public int code = Error.success;
    public String msg = Error.successMsg;
    public Object data = null;



    public static JsonResp Success(Object data, String msg) {
        JsonResp resp = newSelf();
        resp.data = data;
        resp.msg = msg;
        return resp;
    }

    public static JsonResp Success( String msg,Object data) {
        JsonResp resp = newSelf();
        resp.data = data;
        resp.msg = msg;
        return resp;
    }

    public static JsonResp Success(Object data) {
        JsonResp resp = newSelf();
        resp.data = data;
        return resp;
    }

    public static JsonResp Success() {
        JsonResp resp = newSelf();
        return resp;
    }


    public static JsonResp Error(int errCode, String msg) {
        JsonResp resp = newSelf();
        resp.code = (short) errCode;
        resp.msg = msg;
        return resp;
    }

    public static JsonResp Error(String msg) {
        JsonResp resp = newSelf();
        resp.msg = msg;
        resp.code = Error.innerError;
        return resp;
    }

    public static JsonResp Error() {
        JsonResp resp = newSelf();

        resp.msg = "";
        return resp;
    }


    public static JsonResp newSelf() {
        return new JsonResp();
    }


}
