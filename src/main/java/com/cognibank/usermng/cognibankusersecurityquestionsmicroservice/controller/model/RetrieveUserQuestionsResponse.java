package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.controller.model;

public class RetrieveUserQuestionsResponse {

    private Long id;

    private String question;

    public RetrieveUserQuestionsResponse withId(final Long id) {
        setId(id);
        return this;
    }

    public RetrieveUserQuestionsResponse withQuestion(final String question) {
        setQuestion(question);
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "RetrieveUserQuestionsResponse{" +
                "id=" + id +
                ", question='" + question + '\'' +
                '}';
    }
}
