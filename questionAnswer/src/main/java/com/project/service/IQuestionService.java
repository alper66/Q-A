package com.project.service;

import com.project.domain.Question;

import java.util.List;

public interface IQuestionService {
    public void saveQuestion(Question question);

    public void updateQuestion(Question question);

    public void deleteQuestion(Long id);
    public Question findQuestion(Long id);
    public List<Question> getAll();
}
