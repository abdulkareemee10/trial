package com.testing.quizApp.service;

import com.testing.quizApp.QuestionDao.QuestionDao;
import com.testing.quizApp.QuestionDao.RequestNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Component

@Service
public class QuestionService  {

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity< String > saveQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<> ("added succesfully", HttpStatus.CREATED);

    }
    public List<Question> getAllQuestions() {
       return (List<Question>) questionDao.findAll();

    }



    public Question getQuestionById(int id) {
        Optional<Question> question= questionDao.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new RequestNotFound("employee", "id", id);
        }
    }




    public Question updateQuestion(Question question, int id) {
        Question existingQuestion = questionDao.findById(id).orElseThrow(()
                -> new RequestNotFound("questions", "id", id));

        existingQuestion.setQuestionTitle(question.getQuestionTitle());
        existingQuestion.setOption1(question.getOption1());
        existingQuestion.setOption2(question.getOption2());
        existingQuestion.setOption3(question.getOption3());
        existingQuestion.setOption4(question.getOption4());
        existingQuestion.setRightAnswer(question.getRightAnswer());
        existingQuestion.setLevel(question.getLevel());

        questionDao.save(existingQuestion);
        return existingQuestion;
    }

    public void deleteQuestion(int id) {
        Question question = questionDao.findById(id).orElseThrow(() ->new

                RequestNotFound("question", "id", id));
        questionDao.deleteById(id);
    }
}
