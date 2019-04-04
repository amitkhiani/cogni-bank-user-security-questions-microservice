package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.controller.model;

public class ValidateUserAnswerResponse {
    private boolean validated;

    public boolean isValidate() {
        return validated;
    }

    public ValidateUserAnswerResponse withValidated(boolean validated) {
        this.validated = validated;
        return this;
    }
}