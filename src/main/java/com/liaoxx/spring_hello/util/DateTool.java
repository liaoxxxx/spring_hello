package com.liaoxx.spring_hello.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTool {
    /**
     * 获取当前时间
     * @param FormatStr  格式 :"yyyy-MM-dd HH:mm:ss aa"
     * @return
     */
    public static String getFormatStr(String FormatStr){
        Date date = new Date();
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制      格式 :"yyyy-MM-dd HH:mm:ss aa"
        SimpleDateFormat sdf = new SimpleDateFormat(FormatStr);
        return  sdf.format(date);

    }

    /**
     * 获取当前时间
     * @param FormatStr  格式 :"yyyy-MM-dd HH:mm:ss aa"
     * @param microTime 1685255566552
     * @return
     */
    public static String getFormatStr(String FormatStr,long microTime){
        Date date = new Date(microTime);
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat(FormatStr);
        return sdf.format(date);
    }

    public static long getTimestamp(){
      return   new Date().getTime()/1000;
    }
}
