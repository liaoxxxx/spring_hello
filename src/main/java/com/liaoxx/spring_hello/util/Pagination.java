package com.liaoxx.spring_hello.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class Pagination {
    public static final Sort.Direction Desc=Sort.Direction.DESC;
    public static final Sort.Direction ASC=Sort.Direction.ASC;

    public static final int pageDefault=1;
    public static final int limitDefault=10;
    public static final String columnDefault="id";

   /*public static   Pageable pageAble(int pageNum, int pageSize,Sort[] sortList){
       Sort sort =  Sort.by(Sort.Direction.DESC, "id");
        return   new PageRequest(pageNum - 1, pageSize, sort) {}; // （当前页， 每页记录数， 排序方式）
    }*/


    public static Pageable pageAble(int pageNum, int pageSize,Sort sort){

        return   new PageRequest(pageNum - 1, pageSize, sort) {}; // （当前页， 每页记录数， 排序方式）
    }

    public static Pageable pageAble(int pageNum, int pageSize){
        Sort sort =  sort();
        return   new PageRequest(pageNum - 1, pageSize, sort) {}; // （当前页， 每页记录数， 排序方式）
    }

    public static Pageable pageAble(int pageNum){
        Sort sort =  sort();
        return   new PageRequest(pageNum - 1, limitDefault, sort) {}; // （当前页， 每页记录数， 排序方式）
    }

    public static Pageable pageAble(){
        Sort sort =  sort();
        return   new PageRequest(pageDefault - 1, limitDefault, sort) {}; // （当前页， 每页记录数， 排序方式）
    }

    public static Sort sort(){
        return Sort.by(Desc, columnDefault);
    }

    public static Sort sort(Sort.Direction direction,String column){
        return Sort.by(direction, column);
    }
}
