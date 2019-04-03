package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.controller;

import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.model.SecurityQuestion;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.service.SecurityQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/usersecurity")
public class UserSecurityQuestionsController {

    /**
     * Bean needed for calling the service implementation.
     */
    @Autowired
    private SecurityQuestionService securityQuestionService;

    // add new question
    // Not yet implemented
    @PostMapping(path = "/question")
    public String addANewQuestion() {
        return "Thanks!";
    }

    // get all questions
    @GetMapping(path = "/questions")
    public List<String> getAllQuestions() {
        List<String> result = securityQuestionService.getAll()
                .stream().map(SecurityQuestion::getQuestion)
                .collect(Collectors.toList());
        System.out.println("In controller-> " + result);
        return result;
    }


    /*// get user's questions
    /question/{userId}

    // update user's answer for question

    /question/{questionId}/{userId}

    // add user's answer for question
    POST /*/


}
