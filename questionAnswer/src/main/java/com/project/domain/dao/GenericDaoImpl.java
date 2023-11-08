package com.project.domain.dao;

import com.project.util.HibernateUtil;
import com.sun.xml.bind.v2.model.core.ID;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

public abstract class GenericDaoImpl<E, ID extends Serializable> implements GenericDao<E, ID> {

    protected Class<? extends E> entityType;

    public GenericDaoImpl() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        entityType = (Class<? extends E>) parameterizedType.getActualTypeArguments()[0];


    }

    @Override
    public void save(E e) {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(e);
            tx.commit();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }

    }

    @Override
    public void update(E e) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(e);
            tx.commit();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(ID id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            E e=(E) session.load(entityType,id);
            session.delete(e);
            tx.commit();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }

    }

    @Override
    public Optional<E> find(ID id) {

        Session session = null;
        Optional<E> opt;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            E e=(E) session.get(entityType,id);
            opt=Optional.ofNullable(e);
            tx.commit();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
        return opt;
    }
}
