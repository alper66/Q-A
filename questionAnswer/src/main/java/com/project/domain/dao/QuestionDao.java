package com.project.domain.dao;

import com.project.domain.Question;
import com.project.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao extends GenericDaoImpl<Question,Long> {

    @Override
    public List<Question> getAll() {
        Session session = null;
        List<Question> resultList=new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Question> criteriaQuery = cb.createQuery(Question.class);
            Root<Question> root = criteriaQuery.from(Question.class);
            criteriaQuery.select(root);

            Query<Question> query = session.createQuery(criteriaQuery);
            resultList = query.getResultList();
            return resultList;
        } catch (RuntimeException e) {
            throw  e;

        } finally {
            session.close();

        }
    }


}

