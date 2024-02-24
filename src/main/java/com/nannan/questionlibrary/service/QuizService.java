package com.nannan.questionlibrary.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nannan.questionlibrary.dao.QuestionDAO;
import com.nannan.questionlibrary.dao.QuizDAO;
import com.nannan.questionlibrary.model.Questions;
import com.nannan.questionlibrary.model.QuestionsWrapper;
import com.nannan.questionlibrary.model.Quiz;
import com.nannan.questionlibrary.model.UserResponse;

@Service
public class QuizService {
    @Autowired 
    QuestionDAO questionDAO;
    @Autowired
    QuizDAO quizDAO;

    public ResponseEntity<String> generateQuiz(Integer noOfQuestion, String category,String quizTitle){
        try{
             List<Questions> questions = questionDAO.findRandomQuestionsByCategory(noOfQuestion,category);
            Quiz quiz = new Quiz();
            quiz.setQuizTitle(quizTitle);
            quiz.setQuestions(questions);
            quizDAO.save(quiz);
            return new ResponseEntity<>("Quiz Saved successfully.", HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<QuestionsWrapper>> getQuiz(Integer id){
        try{
            Optional<Quiz> quiz = quizDAO.findById(id); 
            List<Questions> questions = quiz.get().getQuestions();
            List<QuestionsWrapper> formattedResponse = new ArrayList<>();
            for (Questions question : questions) {
                formattedResponse.add(new QuestionsWrapper(question.getId(), question.getQuestionDescription(),
                                    question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4()));
            }
            return new ResponseEntity<>(formattedResponse, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> getUserResults(Integer id, List<UserResponse> answers){
        try{
            Optional<Quiz> quiz = quizDAO.findById(id); 
            List<Questions> questions = quiz.get().getQuestions();
            Integer userScore = 0;
            for(UserResponse userResponse:answers){
            for (Questions question : questions) {
                if(userResponse.getId() == question.getId() && userResponse.getAnswer().equalsIgnoreCase(question.getAnswer()))
                {
                    userScore++;
                    break;
                }
            }
        }
            return new ResponseEntity<>("User Score is "+userScore+"/"+questions.size(), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
