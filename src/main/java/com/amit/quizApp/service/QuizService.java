package com.amit.quizApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.amit.quizApp.dao.QuestionDao;
import com.amit.quizApp.dao.QuizDao;
import com.amit.quizApp.model.Question;
import com.amit.quizApp.model.Quiz;

@Service
public class QuizService {

    @Autowired
    QuizDao quizdao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionDao.findQuestionByCategoryNative(category, numQ);
        
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizdao.save(quiz);

        return new ResponseEntity<>("Sucessfully Created Quiz", HttpStatus.CREATED);
    }
}
