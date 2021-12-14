package com.liaoxx.spring_hello.service.common;

import com.liaoxx.spring_hello.entity.common.CommonNav;
import com.liaoxx.spring_hello.repository.common.CommonNavRepository;
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
public class CommonNavService {
    @Resource
    CommonNavRepository navRepository;




    public List<CommonNav> List(Specification<CommonNav> navSpec, int pageNum, int pageSize, String sortColumn , Sort.Direction direction) {
        Pageable pageable = Pagination.pageAble(pageNum,pageSize,sortColumn,direction);
        Page<CommonNav> navPages= navRepository.findAll(navSpec,pageable);
        return new ArrayList<>(navPages.getContent());
    }

    public List<CommonNav> List(Specification<CommonNav> navSpec) {
        return navRepository.findAll(navSpec);
    }


}
