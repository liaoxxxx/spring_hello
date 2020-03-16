package com.liaoxx.spring_hello.controller.index;


import com.liaoxx.spring_hello.entity.Goods;
import com.liaoxx.spring_hello.service.GoodsService;
import com.liaoxx.spring_hello.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
@Controller
@RequestMapping("/goodsapi")
public class GoodsApiController {

    @Autowired
    GoodsService goodsService;




    @ResponseBody
    @RequestMapping( "/recommendList")
    public Map<String, Object> list(){
        int limit=5;
        List<Goods> recommendList=goodsService.getRecommendList(limit);
        return JsonResponse.Success("获取推荐商品成功",recommendList);
    }


    @ResponseBody
    @RequestMapping( "/findone/{id}")
    public Map<String, Object> findOne(@PathVariable int id){
        Goods goodsItem= goodsService.findById(id);
        //Map<String ,Object> map =new HashMap();
        if (goodsItem.getId()>0){
            return JsonResponse.Success("获取商品数据成功",goodsItem);
        }

        return JsonResponse.Success("获取商品数据失败",new Object());
    }


}
