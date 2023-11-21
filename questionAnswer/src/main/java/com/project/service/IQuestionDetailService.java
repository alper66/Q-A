package com.project.service;

import com.project.domain.Question;
import com.project.domain.QuestionDetail;

import java.util.List;

public interface IQuestionDetailService {
    public void saveQuestionDetail(QuestionDetail question);

    public void updateQuestionDetail(QuestionDetail question);

    public void deleteQuestionDetail(Long id);
    public QuestionDetail findQuestionDetail(Long id);
    public List<QuestionDetail> getAll();
}
