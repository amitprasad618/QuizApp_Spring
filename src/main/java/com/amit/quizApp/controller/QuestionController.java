package com.amit.quizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.quizApp.model.Question;
import com.amit.quizApp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestion")
    public List<Question> getAllQuestion() {

        return questionService.getAllQuestions();
    }
    
    @GetMapping("allQuestion/{id}")
    public Question getAllQuestion1(@PathVariable("id") int ID) {
        return questionService.getdatabyId(ID);
    }
}
