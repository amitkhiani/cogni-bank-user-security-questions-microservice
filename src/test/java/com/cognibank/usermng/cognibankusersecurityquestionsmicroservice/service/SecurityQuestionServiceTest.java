package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.service;

import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.model.SecurityQuestion;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.repository.SecurityQuestionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityQuestionServiceTest {
    @Autowired
    private SecurityQuestionService securityQuestionService;

    @Test
    public void shouldAddNewSecurityQuestion() {
        Long newQuestionId = securityQuestionService.add("My new hard to remember question is here!!");

        assertNotEquals("Should return a value other than 0.", 0L, newQuestionId.longValue());
    }

    @Test
    public void shouldGetAllSecurityQuestions() {
        List<SecurityQuestion> questionList = securityQuestionService.getAll();

        assertNotNull("Should return security questions list.", questionList);
        assertNotEquals("Should return at least 1 question.", 0, questionList.size());
    }

}