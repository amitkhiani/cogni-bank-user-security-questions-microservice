package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.controller;

import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.controller.model.CreateUserAnswerAndQuestionRequest;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.controller.model.CreateUserAnswerAndQuestionResponse;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.controller.model.RetrieveUserQuestionsResponse;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.controller.model.ValidateUserAnswerResponse;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.model.SecurityQuestion;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.service.SecurityQuestionService;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.service.UserAnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Api(tags = {"User Security Questions API"})
@SwaggerDefinition(
        tags = {
                @Tag(name = "User Security Questions API", description = "Cogni-Bank User Security Questions API for storing user answers for the security questions.")
        }
)
public interface UserSecurityQuestionsController {


    // Get all questions with Id's, returns list SecurityQuestion objects
    @ApiOperation(value = "Returns all the questions for user sign up.")
    public List<SecurityQuestion> getAllQuestions();

    // To tag answers to the user selected questions.
    @ApiOperation(value = "Allows to store question and answer for a user during  user sign up.")
    public CreateUserAnswerAndQuestionResponse addUserAnswer (String userId, CreateUserAnswerAndQuestionRequest addQuestionRequest);

    @ApiOperation(value = "Retrieve user answer for a submitted question, will be called during password forgotten")
    public List<RetrieveUserQuestionsResponse> getQuestionsForRespectiveUserId(String userId);

    @ApiOperation(value = "Validate the user answer during the password reset ")
    public ValidateUserAnswerResponse checkUserAnswer(String userId, CreateUserAnswerAndQuestionRequest validAnswerRequest);

}