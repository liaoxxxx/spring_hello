package com.liaoxx.spring_hello.util;

import com.liaoxx.spring_hello.entity.BaseEntity;
import com.liaoxx.spring_hello.entity.goods.Goods;
import org.apache.poi.ss.formula.functions.T;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceContext;

@Component
public class NativeQuery {

    @PersistenceContext //注入的是实体管理器,执行持久化操作
    Session session;

    public List<T> getInByField(BaseEntity baseEntity,List<Object> listFields, Map<String,Object> where){
        String sql="select * from "+baseEntity.getTable();
       // List< T> tList= (List<T>) session.createQuery(sql,baseEntity.getClass()).list();
        return null ;
    }

}
