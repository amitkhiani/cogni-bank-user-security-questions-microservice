package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.controller.model;

public class CreateUserAnswerAndQuestionResponse {
    private boolean created;

    public boolean isCreated() {
        return created;
    }

    public CreateUserAnswerAndQuestionResponse withChanged(boolean created) {
        this.created = created;
        return this;
    }
}
