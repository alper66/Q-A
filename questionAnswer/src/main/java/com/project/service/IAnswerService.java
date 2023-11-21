package com.project.service;

import com.project.domain.Answer;


import java.util.List;

public interface IAnswerService {
    public void saveAnswer(Answer answer);

    public void updateAnswer(Answer answer);

    public void deleteAnswer(Long id);
    public Answer findAnswer(Long id);
    public List<Answer> getAll();
}
