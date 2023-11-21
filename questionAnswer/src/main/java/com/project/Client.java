package com.project;

import com.project.domain.Answer;
import com.project.domain.Question;
import com.project.domain.QuestionDetail;
import com.project.domain.enums.QuestionPriority;
import com.project.service.*;

import java.util.List;

public class Client {
    public static void main(String[] args) {

        //demo
//        IQuestionService questionService=new QuestionServiceImpl();
        //save question
       /* Question question1=new Question();
        question1.setName("what is java?");
        question1.setPriority(QuestionPriority.CRITICAL);
*/

//        questionService.saveQuestion(question1);

        //add question details.
//        Question questionFound=questionService.findQuestion(1000L);

/*
        QuestionDetail detail=new QuestionDetail();
        detail.setDescription("it is student question about the java oop concept");
        detail.setQuestion(questionFound);
        IQuestionDetailService questionDetailService=new QuestionDetailServiceImpl();
        questionDetailService.saveQuestionDetail(detail);
*/

        IAnswerService answerService=new AnswerServiceImpl();

        /*Answer answer=new Answer();
        answer.setName("Answer1");
        answer.setDescription("it is oo programming language");
        answer.setQuestion(questionFound);

        answerService.saveAnswer(answer);
        */

        List<Answer> answerList=answerService.getAllByQuesionId(1000L);
        answerList.forEach(a-> System.out.println(a.getId()+":"+a.getName()+":"+a.getDescription()));
    }
}
