package com.liaoxx.spring_hello.service.common;

import com.liaoxx.spring_hello.entity.common.CommonAd;
import com.liaoxx.spring_hello.entity.common.CommonBanner;
import com.liaoxx.spring_hello.repository.common.CommonAdRepository;
import com.liaoxx.spring_hello.util.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommonAdService {
    @Resource
    CommonAdRepository adRepository;




    public List<CommonAd> List(Specification<CommonAd> adSpec, int pageNum, int pageSize, String sortColumn , Sort.Direction direction) {
        Pageable pageable = Pagination.pageAble(pageNum,pageSize,sortColumn,direction);
        Page<CommonAd> adPages= adRepository.findAll(adSpec,pageable);
        return adPages.getContent();
    }

    public List<CommonAd> List(Specification<CommonAd> adSpec) {
        List<CommonAd> adList= adRepository.findAll(adSpec);
        return adList;
    }






}
