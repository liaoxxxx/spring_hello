package com.liaoxx.spring_hello.service.interfaces;

import com.liaoxx.spring_hello.export.ExportI;

public interface ServiceI {
    public String getMsg();
    public int grtCode();
    public ExportI getData();

    public boolean isService();
}
