package com.project.domain;

import javax.persistence.*;

@Entity
@Table(name="t_qDetail")
public class QuestionDetail extends BaseEntity {

    @Column(length = 200)
    private String description;

    @OneToOne
    @JoinColumn(name="question_id")
    private Question question;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
