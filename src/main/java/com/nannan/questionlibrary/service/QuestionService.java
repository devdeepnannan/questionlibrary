package com.nannan.questionlibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nannan.questionlibrary.dao.QuestionDAO;
import com.nannan.questionlibrary.model.Questions;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;
    public List<Questions> getAllQuestion()
    {
        return questionDAO.findAll();
    }

}
