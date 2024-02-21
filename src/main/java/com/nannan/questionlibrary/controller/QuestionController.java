package com.nannan.questionlibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nannan.questionlibrary.model.Questions;
import com.nannan.questionlibrary.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

@Autowired
QuestionService questionService;

    @GetMapping("allQuestion")
    public List<Questions> getAllQuestions(){
        return questionService.getAllQuestion();
        
    }
}
