package com.project.service;

import com.project.domain.Answer;
import com.project.domain.dao.AnswerDao;
import com.project.exception.ResourceNotFoundException;

import java.util.List;

public class AnswerServiceImpl implements IAnswerService {
    private static final AnswerDao answerDao = new AnswerDao();

    @Override
    public void saveAnswer(Answer answer) {
        answerDao.save(answer);
    }

    @Override
    public void updateAnswer(Answer answer) {
        answerDao.update(answer);

    }

    @Override
    public void deleteAnswer(Long id) {
        answerDao.delete(id);
    }

    @Override
    public Answer findAnswer(Long id) {
        return answerDao.find(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Answer not found with id:%d", id)));
    }

    @Override
    public List<Answer> getAll() {
        return answerDao.getAll();
    }

    @Override
    public List<Answer> getAllByQuesionId(Long id) {
       return  answerDao.findAllByQuestionId(id);
    }
}
