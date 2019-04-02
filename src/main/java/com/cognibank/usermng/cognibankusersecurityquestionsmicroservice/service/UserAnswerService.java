package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.service;

public interface UserAnswerService {
    Long addAnswer(String userId, Long questionId, String answer);
    boolean checkAnswer(String userId, Long questionId, String answer);
}
