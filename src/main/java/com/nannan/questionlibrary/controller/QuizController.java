package com.nannan.questionlibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nannan.questionlibrary.model.QuestionsWrapper;
import com.nannan.questionlibrary.model.UserResponse;
import com.nannan.questionlibrary.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("generateQuiz")
    public ResponseEntity<String> generateQuiz(@RequestParam("noOfQuestion") Integer noOfQuestions,
                                            @RequestParam("category") String category,
                                            @RequestParam("quizTitle") String quizTitle)
    {
        return quizService.generateQuiz(noOfQuestions, category, quizTitle);
    }                                        
    
    @GetMapping("getQuiz")
    public ResponseEntity<List<QuestionsWrapper>> getQuiz(@RequestParam("id") Integer id)
    {
        return quizService.getQuiz(id);
    }

    @PostMapping("submit")
    public ResponseEntity<String> getUserResults(@RequestBody List<UserResponse> answers,@RequestParam("id") Integer id)
    {
        return quizService.getUserResults(id,answers);
    }

}
