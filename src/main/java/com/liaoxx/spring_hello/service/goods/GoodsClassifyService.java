package com.liaoxx.spring_hello.service.goods;
import com.liaoxx.spring_hello.export.api.goods.GoodsClassifyDto;
import com.liaoxx.spring_hello.entity.goods.GoodsClassify;
import com.liaoxx.spring_hello.param.admin.goods.GoodsClassifyParam;
import com.liaoxx.spring_hello.repository.goods.GoodsClassifyRepository;
import com.liaoxx.spring_hello.util.SqlTimeTool;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsClassifyService {

    @Resource
    GoodsClassifyRepository goodsClassifyRepository;


    public boolean add(GoodsClassifyParam goodsClassifyParam){
        long timeTamp=SqlTimeTool.getMicroTimeTamp();
        System.out.println(timeTamp);
        GoodsClassify GoodsClassify=new GoodsClassify();
        BeanUtils.copyProperties(goodsClassifyParam,GoodsClassify);
        GoodsClassify.setCreatedAt((int) timeTamp);
        GoodsClassify.setUpdatedAt((int) timeTamp);
        goodsClassifyRepository.save(GoodsClassify);
        return true;
    }



    public ArrayList<GoodsClassifyDto> getList(int page,int pageSize,String cateName){
        //条件
        Specification<GoodsClassify> spec = new Specification<GoodsClassify>() {
            @Override
            public Predicate toPredicate(Root<GoodsClassify> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("cate_name").as(String.class),cateName+"%");
            }


        };
        //排序
      //  Sort sort = new Sort(Sort.Direction.DESC);

        ArrayList<GoodsClassifyDto> listDto = new ArrayList<>();
        List<GoodsClassify> listClassify=goodsClassifyRepository.findAll();
        for (GoodsClassify classify:listClassify) {
            GoodsClassifyDto dto = new GoodsClassifyDto();
            BeanUtils.copyProperties(classify,dto);
            dto.setCreatedAtStr(SqlTimeTool.transMicroTime2Date((long) classify.getCreatedAt()));
            dto.setUpdatedAtStr(SqlTimeTool.transMicroTime2Date((long) classify.getUpdatedAt()));
            listDto.add(dto);
        }
        return listDto;


    }


    public List<GoodsClassify> findAll(){
        //所有的 商品分类
        return  goodsClassifyRepository.findAll();
    }




    public GoodsClassify getById(int id){
        return goodsClassifyRepository.getById(id);
    }


    public GoodsClassify update(GoodsClassify GoodsClassify){
        return goodsClassifyRepository.save(GoodsClassify);
    }
}
