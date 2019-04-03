package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.controller;

import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.model.SecurityQuestion;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.service.SecurityQuestionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(UserSecurityQuestionsController.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class UserSecurityQuestionsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private SecurityQuestionService securityQuestionService;

    @InjectMocks
    private UserSecurityQuestionsController userSecurityQuestionsController;

    @Before
    public void settingUpTheTest() {
        // Initializes the JacksonTester.
        MockitoAnnotations.initMocks(this);
        // MockMvc standalone approach.
        mockMvc = MockMvcBuilders.standaloneSetup(userSecurityQuestionsController).build();
    }

    @Test
    public void testToFetchAllTheQuestions() throws Exception {
        final String question1 = "How are you?";
        final String question2 = "I'm asking how are you?";
        final String question3 = "Seriously, How are you?";
        List<String> expectedResult = Arrays.asList(question1, question2, question3);

        SecurityQuestion secQuestion1 = new SecurityQuestion().withId(1L).withQuestion(question1);
        SecurityQuestion secQuestion2 = new SecurityQuestion().withId(2L).withQuestion(question2);
        SecurityQuestion secQuestion3 = new SecurityQuestion().withId(3L).withQuestion(question3);
        List<SecurityQuestion> listOfQuestions = Arrays.asList(secQuestion1, secQuestion2, secQuestion3);

        // Mocking the service method of get all the security questions.
        Mockito.when(securityQuestionService.getAll()).thenReturn(listOfQuestions);
        // Performing the mock mvc.
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/usersecurity/questions").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0]").value(expectedResult.get(0)))
                .andExpect(jsonPath("$[1]").value(expectedResult.get(1)))
                .andExpect(jsonPath("$[2]").value(expectedResult.get(2)));
    }
}
