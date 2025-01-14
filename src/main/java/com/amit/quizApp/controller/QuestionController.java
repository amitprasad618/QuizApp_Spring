package com.amit.quizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @GetMapping("{id}")
    public Question getAllQuestion1(@PathVariable("id") int ID) {
        return questionService.getdatabyId(ID);
    }

    @GetMapping("category/{category}")
    public List<Question> getAllQuestion1(@PathVariable("category") String category) {
        return questionService.getdatabyCategory(category);
    }

    @PostMapping("add")
    public Question addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @DeleteMapping("delete/{id}")
    public String deleteQuestion(@PathVariable("id") int ID) {
        questionService.deleteQuestion(ID);
        return "Deleted Sucessfully";
    }
}
