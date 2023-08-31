package com.testing.quizApp.controller;

import com.testing.quizApp.service.Question;
import com.testing.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
private QuestionService questionService;

    @PostMapping()
    public ResponseEntity<String> saveQuestion(@RequestBody Question question){

        return  questionService.saveQuestion(question);
    }
    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
        @GetMapping("{id}")
        public ResponseEntity<Question> getQuestionById ( @PathVariable("id") int questionId)
        {
            return new ResponseEntity<Question>(questionService.getQuestionById(questionId), HttpStatus.OK);
        }



    @PutMapping("{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable("id") int id, @RequestBody Question question){
    try

    {
        return new ResponseEntity<Question>(questionService.updateQuestion(question, id), HttpStatus.CREATED);
    }
    catch (Exception e){
        e.printStackTrace();
        }
        return new ResponseEntity<>( question, HttpStatus.BAD_REQUEST);
        }
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteQuestion(@PathVariable("id") int id){
        questionService.deleteQuestion(id);
        return new ResponseEntity<String>("employee deleted", HttpStatus.OK);
    }






    }



