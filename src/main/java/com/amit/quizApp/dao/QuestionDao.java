package com.amit.quizApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amit.quizApp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    
    @Query(value = "SELECT * FROM question WHERE id = :ID", nativeQuery = true)
    Question findQuestionByIdNative(@Param("ID") int ID);

    @Query(value = "SELECT * FROM question WHERE category = :category", nativeQuery = true)
    List<Question> findQuestionByCategoryNative(@Param("category") String category);

    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery= true)
    List<Question> findQuestionByCategoryNative(String category, int numQ);

}
