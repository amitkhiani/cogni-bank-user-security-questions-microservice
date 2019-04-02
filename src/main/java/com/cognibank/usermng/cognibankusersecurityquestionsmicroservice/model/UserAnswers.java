package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.model;


import javax.persistence.*;

@Entity
@Table(indexes = {@Index(columnList = "userId")},
        uniqueConstraints = {@UniqueConstraint(columnNames = {"userId", "question_id"})})
public class UserAnswers {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private SecurityQuestion question;
    @Column(nullable = false)
    private String answer;

    public Long getId() {
        return id;
    }

    public UserAnswers withId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public UserAnswers withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public SecurityQuestion getQuestion() {
        return question;
    }

    public UserAnswers withQuestion(SecurityQuestion question) {
        this.question = question;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public UserAnswers withAnswer(String answer) {
        this.answer = answer;
        return this;
    }
}
