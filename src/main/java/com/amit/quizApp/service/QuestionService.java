package com.amit.quizApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.amit.quizApp.dao.QuestionDao;
import com.amit.quizApp.model.Question;


@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Question> getdatabyId(int ID) {
        try{
            return new ResponseEntity<>(questionDao.findQuestionByIdNative(ID), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new Question(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getdatabyCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findQuestionByCategoryNative(category), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Question> addQuestion(Question question) {
        try{
            return new ResponseEntity<>(questionDao.save(question), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new Question(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        try{
            questionDao.deleteById(id);
            return new ResponseEntity<>("Deleted Sucessfully", HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("BAD REQUEST", HttpStatus.BAD_REQUEST);
    }

}
