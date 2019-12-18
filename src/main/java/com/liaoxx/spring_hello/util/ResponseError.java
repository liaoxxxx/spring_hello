package com.liaoxx.spring_hello.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseError implements ResponseInterface {
    public byte status =1;
    public short code =200;
    public String Msg ="1";
    public Map<String,Object> data =new HashMap<>();
    public String success ="success";


}
