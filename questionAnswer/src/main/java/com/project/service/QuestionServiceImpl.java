package com.project.service;

import com.project.domain.Question;
import com.project.domain.dao.QuestionDao;
import com.project.exception.ResourceNotFoundException;

import java.util.List;

public class QuestionServiceImpl implements IQuestionService{
    private  static final QuestionDao questionDao=new QuestionDao();

    @Override
    public void saveQuestion(Question question) {
        questionDao.save(question);
    }

    @Override
    public void updateQuestion(Question question) {

        questionDao.update(question);

    }

    @Override
    public void deleteQuestion(Long id) {
        questionDao.delete(id);
    }

    @Override
    public Question findQuestion(Long id) {
      return questionDao.find(id).orElseThrow(()->new ResourceNotFoundException("Question not found with id"+id));
    }

    @Override
    public List<Question> getAll() {
        return questionDao.getAll();

    }
}
