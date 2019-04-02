package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAnswerServiceTest {
    @Autowired
    private UserAnswerService userAnswerService;

    @Test
    public void shouldAddUserAnswerToASecurityQuestion() {
        String expectedUserId = "173abcb6-a128-4558-b839-4d64e9105fee";
        Long expectedQuestionId = 1L;
        String expectedUserAnswer = "Test answer";

        final Long newUserAnswer = userAnswerService.addAnswer(expectedUserId, expectedQuestionId, expectedUserAnswer);
        assertTrue("Should add a user answer", 0L <= newUserAnswer);

        boolean checkResult = userAnswerService.checkAnswer(expectedUserId, expectedQuestionId, expectedUserAnswer);
        assertTrue("Answer should match", checkResult);

        checkResult = userAnswerService.checkAnswer(expectedUserId, expectedQuestionId, "Some other answer");
        assertFalse("Answer should not match", checkResult);
    }
}