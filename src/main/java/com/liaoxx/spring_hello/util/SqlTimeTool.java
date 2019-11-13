package com.liaoxx.spring_hello.util;

import java.text.SimpleDateFormat;

public class SqlTimeTool {
   public static long getMicroTimeTamp(){
       return System.currentTimeMillis();
   }
   public static String transMicroTime2Date(Long MicroTimeTamp){
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       return dateFormat.format(MicroTimeTamp);
   }
}
