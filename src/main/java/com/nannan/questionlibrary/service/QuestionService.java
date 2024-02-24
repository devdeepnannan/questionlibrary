package com.nannan.questionlibrary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nannan.questionlibrary.dao.QuestionDAO;
import com.nannan.questionlibrary.model.Questions;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;
    public ResponseEntity<List<Questions>> getAllQuestion()
    {
        try{
            return new ResponseEntity<>(questionDAO.findAll(),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {
        try{
        return  new ResponseEntity<>(questionDAO.findByCategory(category),HttpStatus.OK);
    }catch(Exception e){
        e.printStackTrace();
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    }

    public ResponseEntity<String> addQuestion(Questions question) {
        try{
        questionDAO.save(question);
        return new ResponseEntity<>("Question was successfully saved",HttpStatus.OK);
    }catch(Exception e){
        e.printStackTrace();
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
    }

    public ResponseEntity<String> addMultipleQuestions(List<Questions> questions) {
        try{
        questionDAO.saveAll(questions);
        return new ResponseEntity<>("Question was successfully saved",HttpStatus.OK);
    }catch(Exception e){
        e.printStackTrace();
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
    }

    public ResponseEntity<String> updateQuestion(Questions question) {
        try{
        questionDAO.save(question);
        return new ResponseEntity<>("Question was successfully updated",HttpStatus.OK);
    }catch(Exception e){
        e.printStackTrace();
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
    }

    public ResponseEntity<String> deleteQuestion(Integer id){
        try{
            questionDAO.deleteById(id);
            return new ResponseEntity<>("Question was successfully deleted",HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
