package com.liaoxx.spring_hello.util;


import com.liaoxx.spring_hello.entity.BaseEntity;
import com.liaoxx.spring_hello.entity.goods.Goods;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class SpecUtil {
    // 时区对象
    private static final ZoneOffset ZONE_OFFSET = ZoneOffset.of("+8");
    // 日期时间格式化对象
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 模糊匹配头部, like %?1
     *
     * @param fieldName 实体中的字段名称
     * @param value     固定值
     * @return 查询条件的封装对象
     */
    public static Specification likeStart(String fieldName, String value) {
        return (root, query, cb) -> cb.like(root.get(fieldName), "%" + value);
    }

    /**
     * 模糊匹配尾部, like ?1%
     *
     * @param fieldName 实体中的字段名称
     * @param value     固定值
     * @return 查询条件的封装对象
     */
    public static Specification likeEnd(String fieldName, String value) {
        return (root, query, cb) -> cb.like(root.get(fieldName), value + "%");
    }

    /**
     * 完全模糊匹配 ， like %?1%
     *
     * @param fieldName 实体中的字段名称
     * @param value     固定值
     * @return 查询条件的封装对象
     */
    public static Specification like(String fieldName, String value) {
        return likeBuild(fieldName, "%" + value + "%");
    }

    private static Specification likeBuild(String fieldName, String value) {
        return (root, query, cb) -> cb.like(root.get(fieldName), "%" + value + "%");
    }

    /**
     * 任意值相等比较
     *
     * @param fieldName 实体中的字段名称
     * @param value     比较值
     * @return 查询条件的封装对象
     */
    public static <T> Specification eq(String fieldName, T value) {
        return (root, query, cb) -> cb.equal(root.get(fieldName), value);
    }

    /**
     * 比较日期区间
     *
     * @param fieldName 实体中的字段名称
     * @param min       最小日期值
     * @param max       最大日期值
     * @return 查询条件的封装对象
     */
    public static Specification betweenDate(String fieldName, Date min, Date max) {
        LocalDateTime lmin = LocalDateTime.ofInstant(min.toInstant(), ZONE_OFFSET);
        LocalDateTime lmax = LocalDateTime.ofInstant(max.toInstant(), ZONE_OFFSET);
        return (root, query, cb) -> cb.between(root.get(fieldName).as(String.class), DATE_TIME_FORMATTER.format(lmin), DATE_TIME_FORMATTER.format(lmax));
    }

    /**
     * 比较任意值的区间
     *
     * @param fieldName 实体中的字段名称
     * @param min       最小值
     * @param max       最大值
     * @param <T>
     * @return 查询条件的封装对象
     */
    public static <T extends Comparable> Specification between(String fieldName, T min, T max) {
        return (root, query, cb) -> cb.between(root.get(fieldName), min, max);
    }


    /**
     * 数值大于比较
     *
     * @param <T>
     * @param fieldName 实体中的字段名称
     * @param value     比较值
     * @return 查询条件的封装对象
     */
    public static <T extends Number> Specification gt(String fieldName, T value) {
        return (root, query, cb) -> cb.gt(root.get(fieldName).as(Number.class), value);
    }


    /**
     * 数值大于等于比较
     *
     * @param fieldName 实体中的字段名称
     * @param value     比较值
     * @param <T>
     * @return 查询条件的封装对象
     */
    public static <T extends Comparable> Specification gte(String fieldName, T value) {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get(fieldName), value);
    }

    /**
     * 数值小于比较
     *
     * @param fieldName 实体中的字段名称
     * @param value     比较值
     * @param <T>
     * @return 查询条件的封装对象
     */
    public static <T extends Number> Specification lt(String fieldName, T value) {
        return (root, query, cb) -> cb.lt(root.get(fieldName).as(Number.class), value);
    }

    /**
     * 数值小于等于比较
     *
     * @param fieldName 实体中的字段名称
     * @param value     比较值
     * @param <T>
     * @return 查询条件的封装对象
     */
    public static <T extends Comparable> Specification lte(String fieldName, T value) {
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get(fieldName), value);
    }

    /**
     * 字段为null条件
     * @param fieldName 实体中的字段名称
     * @return 查询条件的封装对象
     */
    public static Specification isNull(String fieldName){
        return (root, query, cb) -> cb.isNull(root.get(fieldName));
    }

    /**
     * 字段不为null条件
     * @param fieldName 实体中的字段名称
     * @return 查询条件的封装对象
     */
    public static Specification isNotNull(String fieldName){
        return (root, query, cb) -> cb.isNotNull(root.get(fieldName));
    }

    /**
     * in 条件
     * @param fieldName
     * @param values
     * @return
     */
    public static Specification in(String fieldName,Object...values){
        return (root, query, cb) -> root.get(fieldName).in(values);
    }


   public static <T> Specification fromMap(Map<String, Object> searchMap,Specification  specification){
        assert specification !=null ;
       for (Map.Entry<String, Object> entry : searchMap.entrySet()) {
           String key;
           String[] filedAndOption;
           Object value;
           try {
               key = entry.getKey();
               value=entry.getValue();
               System.out.println("---------------start--------------");
               System.out.println(key);
               System.out.println(value);
               System.out.println("---------------end--------------");
               //跳过 null ，空都跳过
               if (value == null || key==null||  value.toString().trim().length() == 0 || key.trim().length() == 0) {
                   continue;
               }
               // 1. 通过 | 分割key 判断where 条件类型
               filedAndOption=  key.split("\\|");
               String filed=  filedAndOption[0];
               if (filedAndOption.length==2){
                   String option=  filedAndOption[1];
                   //比较
                   if (option.equals("lt")) {
                       specification = specification.and(SpecUtil.lt(filed, (Number) value));
                   }
                   if (option.equals("lte")) {
                       specification = specification.and(SpecUtil.lte(filed, (Comparable) value));
                   }
                   if (option.equals("gt")) {
                       specification = specification.and(SpecUtil.gt(filed, (Number)value));
                   }
                   if (option.equals("gte")) {
                       specification = specification.and(SpecUtil.gte(filed, (Comparable) value));
                   }
                   //模糊搜索
                   if (option.equals( "like")){
                       specification=specification.and(SpecUtil.like(filed,(String)value));
                   }
                   if (option.equals( "lkS")){
                       specification=specification.and(SpecUtil.likeStart(filed,(String)value));
                   }
                   if (option.equals( "lkE")){
                       specification=specification.and(SpecUtil.likeEnd(filed,(String)value));
                   }
                   if (option.equals( "eq")){
                       specification=specification.and(SpecUtil.eq(filed,value));
                   }
               }
               if (filedAndOption.length == 1) {
                   System.out.println("----------length ==1 -----start--------------");
                   System.out.println(key);
                   System.out.println(value);
                   System.out.println(specification);
                   System.out.println("-----------length ==1----end--------------");
                   specification = specification.and(SpecUtil.eq(key, value));
               }
           } catch (IllegalStateException ise) {
               // this usually means the entry is no longer in the map.
               throw new ConcurrentModificationException(ise);
           }
       }
       return specification;
    }

}