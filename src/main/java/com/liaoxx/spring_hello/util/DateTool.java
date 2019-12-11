package com.liaoxx.spring_hello.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTool {
    public static String getFormatStr(String FormatStr){
        Date date = new Date();
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制      格式 :"yyyy-MM-dd HH:mm:ss aa"
        SimpleDateFormat sdf = new SimpleDateFormat(FormatStr);
        return  sdf.format(date);

    }

    public static String getFormatStr(String FormatStr,long microTime){
        Date date = new Date(microTime);
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat(FormatStr);
        return sdf.format(date);
    }
}
