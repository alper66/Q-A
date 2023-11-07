package com.project.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(generator = "sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence",sequenceName = "question_answer_seq",initialValue = 1000,allocationSize = 10)
    private Long id;
    @Version
    private Long version;

    @Column(name="create_on")
    private LocalDateTime createOn=LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }
}
