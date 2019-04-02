package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.model;


import javax.persistence.*;

@Entity
public class SecurityQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    public Long getId() {
        return id;
    }

    public SecurityQuestion withId(Long id) {
        this.id = id;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public SecurityQuestion withQuestion(String question) {
        this.question = question;
        return this;
    }
}
