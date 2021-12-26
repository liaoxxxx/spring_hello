package com.liaoxx.spring_hello.service.common;

import com.liaoxx.spring_hello.dto.api.common.CommonAdListDto;
import com.liaoxx.spring_hello.entity.common.CommonAd;
import com.liaoxx.spring_hello.entity.goods.Goods;
import com.liaoxx.spring_hello.repository.common.CommonAdRepository;
import com.liaoxx.spring_hello.util.Pagination;
import com.liaoxx.spring_hello.util.SpecUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CommonAdService {
    @Resource
    CommonAdRepository adRepository;




    public List<CommonAd> list(Specification<CommonAd> adSpec, int pageNum, int pageSize, String sortColumn , Sort.Direction direction) {
        Pageable pageable = Pagination.pageAble(pageNum,pageSize,sortColumn,direction);
        Page<CommonAd> adPages= adRepository.findAll(adSpec,pageable);
        return adPages.getContent();
    }

    public List<CommonAd> list(Specification<CommonAd> adSpec) {
        List<CommonAd> adList= adRepository.findAll(adSpec);
        return adList;
    }

    public CommonAdListDto list(Map<String ,String[]> paramMap, int pageNum, int pageSize) {
        CommonAdListDto adListDto =new CommonAdListDto();
        adListDto.page=pageNum;
        adListDto.pagesize=pageSize;
        Pageable pageable = Pagination.pageAble(pageNum,pageSize);
        Specification<CommonAd> specification=  SpecUtil.fromRequestParamMap(paramMap,Goods.class);
        Page<CommonAd> adPage= adRepository.findAll(specification,pageable);
        adListDto.count=adPage.getTotalElements();
        adListDto.list=adPage.getContent();
        return adListDto;
    }






}
