package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.service;

import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.model.SecurityQuestion;

import java.util.List;

public interface SecurityQuestionService {
    List<SecurityQuestion> getAll();
    Long add(String question);
}
