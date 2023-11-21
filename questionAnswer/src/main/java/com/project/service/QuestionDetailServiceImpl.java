package com.project.service;

import com.project.domain.QuestionDetail;
import com.project.domain.dao.QuestionDetailDao;
import com.project.exception.ResourceNotFoundException;

import java.util.List;

public class QuestionDetailServiceImpl implements IQuestionDetailService {
    private static final QuestionDetailDao detailDao=new QuestionDetailDao();

    @Override
    public void saveQuestionDetail(QuestionDetail questionDetail) {
        detailDao.save(questionDetail);
    }

    @Override
    public void updateQuestionDetail(QuestionDetail questionDetail) {
        detailDao.update(questionDetail);
    }

    @Override
    public void deleteQuestionDetail(Long id) {

        detailDao.delete(id);
    }

    @Override
    public QuestionDetail findQuestionDetail(Long id) {

        return detailDao.find(id).orElseThrow(()->new ResourceNotFoundException("questionDetail not found with id"+id));
    }

    @Override
    public List<QuestionDetail> getAll() {
        return detailDao.getAll();
    }


}
