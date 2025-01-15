package com.amit.quizApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.amit.quizApp.dao.QuestionDao;
import com.amit.quizApp.dao.QuizDao;
import com.amit.quizApp.model.Question;
import com.amit.quizApp.model.QuestionWrapper;
import com.amit.quizApp.model.QuestionsResponse;
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

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int id) {
        Optional<Quiz> quiz = quizdao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();

        for(Question q : questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestion_title(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionForUser.add(qw);
        }

        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<QuestionsResponse> responses) {
        Quiz quiz = quizdao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i=0;
        for(QuestionsResponse res : responses) {
            if(res.getResponse().equals(questions.get(i).getRightanswer()))
                right++;
            i++;
        }

        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
