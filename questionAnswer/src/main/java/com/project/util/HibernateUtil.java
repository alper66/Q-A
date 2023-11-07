package com.project.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {

        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }catch (Throwable t){
            System.err.println("Session Factory could not be created:"+t);
            throw new ExceptionInInitializerError();

        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;

    }
}
