package com.liaoxx.spring_hello.controller.api.goods;

import com.liaoxx.spring_hello.dto.api.goods.GoodsListDto;

import com.liaoxx.spring_hello.entity.goods.Goods;
import com.liaoxx.spring_hello.param.api.goods.GoodsListParam;
import com.liaoxx.spring_hello.service.goods.GoodsService;
import com.liaoxx.spring_hello.util.response.JsonResp;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600,methods ={RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
@RestController
@RequestMapping("/xx/goods")
public class GoodsController {

    @Resource
    GoodsService goodsService;

    @GetMapping(value = "/list")
    public JsonResp list(@RequestBody GoodsListParam goodsListParam){
       GoodsListDto goodsListDto =goodsService.list(goodsListParam);
        return JsonResp.Success(goodsListDto);
    }


    @GetMapping(value = "/test")
    public JsonResp test(){
        HashMap<String ,Object> searchMap =new HashMap();
        searchMap.put("isNew",1652566600);

        Specification<Goods> specification;
        for (Map.Entry<String, Object> entry : searchMap.entrySet()) {
            String key;
            String[] filedAndOption;
            Object value;
            try {
                key = entry.getKey();
                // 1. 通过 | 分割key 判断where 条件类型
                filedAndOption=  key.split("\\|");
                if (filedAndOption.length==2){

                }
                if (filedAndOption.length==1){

                }
                System.out.println("___________________________filedAndOption[0]__________________________________________");
                System.out.println(filedAndOption[0]);
                System.out.println(filedAndOption[1]);
                System.out.println(filedAndOption[2]);
                System.out.println(filedAndOption[3]);
                System.out.println(filedAndOption[4]);
               //System.out.println(filedAndOption[5]);
               //System.out.println(filedAndOption[6]);
               //System.out.println(filedAndOption[7]);


                value = entry.getValue();
            } catch (IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                throw new ConcurrentModificationException(ise);
            }
        }
        return  JsonResp.Success(searchMap);
    }
}
