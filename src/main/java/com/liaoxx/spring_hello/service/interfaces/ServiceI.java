package com.liaoxx.spring_hello.service.interfaces;

import com.liaoxx.spring_hello.dto.DtoI;

public interface ServiceI {
    public String getMsg();
    public int grtCode();
    public DtoI getData();

    public boolean isService();
}
