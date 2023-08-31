package com.testing.quizApp.service;

import com.testing.quizApp.service.Question;

import java.util.List;

public interface QuestionServiceInt {

    Question saveQuestion(Question employee);

    List<Question> getAllQuestions();

    Question getQuestionById(int id);



    Question updateQuestion(Question question, int id);


    void deleteQuestion(int id);

}
