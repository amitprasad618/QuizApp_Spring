package com.amit.quizApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amit.quizApp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    
    @Query(value = "SELECT * FROM questions WHERE id = :ID", nativeQuery = true)
    Question findQuestionByIdNative(@Param("ID") int ID);

    @Query(value = "SELECT * FROM questions", nativeQuery = true)
    List<Question> findAll();
    
}
