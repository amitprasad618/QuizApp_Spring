package com.amit.quizApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.quizApp.dao.QuestionDao;
import com.amit.quizApp.model.Question;


@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public Question getdatabyId(int ID) {
        return questionDao.findQuestionByIdNative(ID);
    }

    public List<Question> getdatabyCategory(String category) {
        return questionDao.findQuestionByCategoryNative(category);
    }

    public Question addQuestion(Question question) {
        return questionDao.save(question);
    }

    public void deleteQuestion(int id) {
        questionDao.deleteById(id);
    }

}
