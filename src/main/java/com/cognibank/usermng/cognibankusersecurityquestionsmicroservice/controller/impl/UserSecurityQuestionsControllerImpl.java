package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.controller.impl;

import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.controller.UserSecurityQuestionsController;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.controller.model.CreateUserAnswerAndQuestionRequest;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.controller.model.CreateUserAnswerAndQuestionResponse;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.controller.model.RetrieveUserQuestionsResponse;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.controller.model.ValidateUserAnswerResponse;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.model.SecurityQuestion;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.service.SecurityQuestionService;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/users/management/securityquestions")
//@CrossOrigin("*")
@CrossOrigin("*")
public class UserSecurityQuestionsControllerImpl implements UserSecurityQuestionsController {

    /**
     * Bean needed for calling the service implementation for security questions.
     */
    @Autowired
    private SecurityQuestionService securityQuestionService;

    /**
     * Bean needed for calling the service implementation for user answers to respective questions.
     */
    @Autowired
    private UserAnswerService userAnswerService;

//    // add new question
//    // ToDo: Not yet implemented
//    @PostMapping(path = "/question")
//    public String addANewQuestion() {
//        return "Thanks!";
//    }


    // Get all questions with Id's, returns list SecurityQuestion objects
    @GetMapping(path = "/getAllQuestions")
    public List<SecurityQuestion> getAllQuestions() {
        List<SecurityQuestion> result = securityQuestionService.getAll();
        return result;
    }

    // To tag answers to the user selected questions.
    @PostMapping(path = "/createUserAnswer/{userId}")
    public CreateUserAnswerAndQuestionResponse addUserAnswer(@PathVariable String userId, @Valid @RequestBody CreateUserAnswerAndQuestionRequest addQuestionRequest) {
        Long generatedId = userAnswerService.addAnswer(userId, addQuestionRequest.getQuestionId(), addQuestionRequest.getAnswer());
        if(generatedId != null) {
            return new CreateUserAnswerAndQuestionResponse().withChanged(true);
        }
        return new CreateUserAnswerAndQuestionResponse().withChanged(false);
    }

    @GetMapping(path = "/getQuestion/{userId}")
    public List<RetrieveUserQuestionsResponse> getQuestionsForRespectiveUserId(@PathVariable String userId) {
        final List<SecurityQuestion> securityQuestions = userAnswerService.getUserQuestions(userId);
        final List<RetrieveUserQuestionsResponse> questionsResponse = securityQuestions
                .stream()
                .map(p -> new RetrieveUserQuestionsResponse().withId(p.getId()).withQuestion(p.getQuestion()))
                .collect(Collectors.toList());
        return questionsResponse;
    }

    @PostMapping(path = "/checkUserAnswer/{userId}")
    public ValidateUserAnswerResponse checkUserAnswer(@PathVariable String userId, @Valid @RequestBody CreateUserAnswerAndQuestionRequest validAnswerRequest) {
        final boolean isValidAnswer = userAnswerService.checkAnswer(userId,validAnswerRequest.getQuestionId(), validAnswerRequest.getAnswer());
        return new ValidateUserAnswerResponse().withValidated(isValidAnswer);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
    }

}