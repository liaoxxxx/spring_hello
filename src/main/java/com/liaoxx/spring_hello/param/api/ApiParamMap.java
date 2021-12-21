package com.liaoxx.spring_hello.param.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.liaoxx.spring_hello.util.Pagination;

import java.util.HashMap;
import java.util.Map;

public class ApiParamMap {
    public ApiParamMap(Map<String, String[]> map){
        this.page=map.get("page")!=null ? Integer .parseInt(map.get("page")[0]):Pagination.pageDefault;
        this.page=map.get("pagesize")!=null ? Integer .parseInt(map.get("pagesize")[0]):Pagination.limitDefault;
        Map<String,String[]> mapTmp = new HashMap<String,String[]>(map);
        mapTmp.remove("page");
        mapTmp.remove("pagesize");
        this.paramMap=mapTmp;
    }
    @JsonProperty(value = "page")
    public int page = Pagination.pageDefault;
    @JsonProperty(value = "pagesize")
    public int pagesize=Pagination.limitDefault;


    public  Map<String ,String[]> paramMap;
}
