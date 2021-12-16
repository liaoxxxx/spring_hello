package com.liaoxx.spring_hello.service.common;

import com.liaoxx.spring_hello.entity.common.CommonBanner;
import com.liaoxx.spring_hello.repository.common.CommonBannerRepository;
import com.liaoxx.spring_hello.util.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommonBannerService {
    @Resource
    CommonBannerRepository bannerRepository;




    public List<CommonBanner> List(Specification<CommonBanner> bannerSpec, int pageNum, int pageSize, String sortColumn , Sort.Direction direction) {
        Pageable pageable = Pagination.pageAble(pageNum,pageSize,sortColumn,direction);
        Page<CommonBanner> bannerPages= bannerRepository.findAll(bannerSpec,pageable);
        return new ArrayList<>(bannerPages.getContent());
    }

    public List<CommonBanner> List(Specification<CommonBanner> bannerSpec) {
        return bannerRepository.findAll(bannerSpec);
    }





}
