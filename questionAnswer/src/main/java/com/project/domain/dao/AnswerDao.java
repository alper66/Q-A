package com.project.domain.dao;

import com.project.domain.Answer;
import com.project.domain.Question;
import com.project.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AnswerDao extends GenericDaoImpl<Answer,Long> {

    @Override
    public List<Answer> getAll() {
        Session session = null;
        List<Answer> resultList = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Answer> criteriaQuery = cb.createQuery(Answer.class);
            Root<Answer> root = criteriaQuery.from(Answer.class);
            criteriaQuery.select(root);

            Query<Answer> query = session.createQuery(criteriaQuery);
            resultList = query.getResultList();
            return resultList;
        } catch (RuntimeException e) {
            throw e;

        } finally {
            session.close();

        }
    }

    public List<Answer> findAllByQuestionId(Long id){
            Session session = null;
            List<Answer> resultList=new ArrayList<>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                CriteriaBuilder cb = session.getCriteriaBuilder();
                CriteriaQuery<Answer> criteriaQuery = cb.createQuery(Answer.class);
                Root<Answer> root = criteriaQuery.from(Answer.class);
                criteriaQuery.select(root);

                Query<Answer> query = session.createQuery(criteriaQuery);
                resultList = query.getResultList();
                return resultList;
            } catch (RuntimeException e) {
                throw  e;

            } finally {
                session.close();

            }

        }

}
