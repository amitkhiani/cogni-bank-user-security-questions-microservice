package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.service;

import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.model.SecurityQuestion;

import java.util.List;

public interface UserAnswerService {
    Long addAnswer(String userId, Long questionId, String answer);
    boolean checkAnswer(String userId, Long questionId, String answer);
    List<SecurityQuestion> getUserQuestions(String userId);
}
