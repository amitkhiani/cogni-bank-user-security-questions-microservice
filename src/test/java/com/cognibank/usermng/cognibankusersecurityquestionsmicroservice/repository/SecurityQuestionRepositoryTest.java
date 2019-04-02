package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.repository;

import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.model.SecurityQuestion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityQuestionRepositoryTest {

    @Autowired
    private SecurityQuestionRepository securityQuestionRepository;


    @Test
    public void shouldCreateNewSecurityQuestion() {
        SecurityQuestion question = securityQuestionRepository.save(
                new SecurityQuestion()
                        .withQuestion("My new hard to remember question is here!!")
        );

        assertNotNull("Question must have an ID.", question.getId());
    }
}