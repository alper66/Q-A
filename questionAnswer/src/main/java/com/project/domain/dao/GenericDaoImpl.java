package com.project.domain.dao;

import com.sun.xml.bind.v2.model.core.ID;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class GenericDaoImpl <E, ID extends Serializable> implements GenericDao <E, ID> {

    protected Class<? extends E> entityType;
    public GenericDaoImpl(){
       Type type= getClass().getGenericSuperclass();
        ParameterizedType parameterizedType=(ParameterizedType) type;
        entityType=(Class<? extends E>)parameterizedType.getActualTypeArguments()[0];


    }

    @Override
    public void save(E t) {

    }


}
