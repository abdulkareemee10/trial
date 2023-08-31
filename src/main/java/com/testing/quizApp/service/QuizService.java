package com.testing.quizApp.service;

import com.testing.quizApp.QuestionDao.QuestionDao;
import com.testing.quizApp.QuestionDao.QuizDao;
import Model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String id, int numQ, String title) {

        List<Question> questions = questionDao.findRandomQuestionById(id, numQ);

        Quiz  quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(questions);
        quizDao.save(quiz);

       return new ResponseEntity<>("success", HttpStatus.CREATED);
    }


}
