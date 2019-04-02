package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.repository;

import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.model.SecurityQuestion;
import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.model.UserAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswers, Long> {
    Optional<UserAnswers> findByUserIdAndQuestionIdAndAnswer(String userId, Long questionId, String answer);
}
