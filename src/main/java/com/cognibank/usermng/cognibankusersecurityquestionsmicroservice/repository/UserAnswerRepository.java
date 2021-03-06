package com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.repository;

import com.cognibank.usermng.cognibankusersecurityquestionsmicroservice.model.UserAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswers, Long> {
    Optional<UserAnswers> findByUserIdAndQuestionIdAndAnswerIgnoreCase(String userId, Long questionId, String answer);
    List<UserAnswers> findByUserId(String userId);
}
