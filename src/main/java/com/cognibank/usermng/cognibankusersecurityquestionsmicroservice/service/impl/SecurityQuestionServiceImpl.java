package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.service.impl;

import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.model.SecurityQuestion;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.repository.SecurityQuestionRepository;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.service.SecurityQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityQuestionServiceImpl implements SecurityQuestionService {

    @Autowired
    private SecurityQuestionRepository securityQuestionRepository;

    @Override
    public List<SecurityQuestion> getAll() {
        return securityQuestionRepository.findAll();
    }

    @Override
    public Long add(String question) {
        return securityQuestionRepository.save(
                new SecurityQuestion()
                        .withQuestion(question))
                .getId();
    }
}
