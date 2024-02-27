package com.nannan.questionlibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nannan.questionlibrary.model.Questions;
import com.nannan.questionlibrary.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

@Autowired
QuestionService questionService;

    @GetMapping("allQuestion")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        return questionService.getAllQuestion();
        
    }

    @GetMapping("getByCategory")
    public ResponseEntity<List<Questions>> getQuestionsByCategory(@RequestParam("category") String category){
        return questionService.getQuestionsByCategory(category);
        
    }

    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Questions question){
        return questionService.addQuestion(question);
    }
      
    @PostMapping("addMultipleQuestions")
    public ResponseEntity<String> addMultipleQuestions(@RequestBody List<Questions> questions){
        return questionService.addMultipleQuestions(questions);
    }

    @PutMapping("updateQuestion")
    public ResponseEntity<String> updateQuestion(@RequestBody Questions question){
        return questionService.updateQuestion(question);
    }

    @DeleteMapping("deleteQuestion/{id}")
        public ResponseEntity<String> deleteQuestion(@PathVariable("id") Integer id){
            return questionService.deleteQuestion(id);
        }   
    
}
