package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.controller.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.*;

public class CreateUserAnswerAndQuestionRequest {

    @NotNull(message = "{createUserAnswerAndQuestion.error.message.questionId}")
    private long questionId;

    @NotNull(message = "{createUserAnswerAndQuestion.error.message.answer}")
    @NotBlank(message = "{createUserAnswerAndQuestion.error.message.answer}")
    @Size(min = 3, max = 64, message = "{createUserAnswerAndQuestion.error.message.answer.size}")
    private String answer;

    public CreateUserAnswerAndQuestionRequest withQuestionId(long questionId) {
        setQuestionId(questionId);
        return this;
    }

    public CreateUserAnswerAndQuestionRequest withAnser(String answer) {
        setAnswer(answer);
        return this;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}