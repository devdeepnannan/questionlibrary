package com.nannan.questionlibrary.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nannan.questionlibrary.model.Questions;

@Repository
public interface QuestionDAO extends JpaRepository<Questions, Integer>{
    public List<Questions> findByCategory(String category);
    
    @Query(value = "select * from questions q where q.category=:category order by RANDOM() LIMIT :noOfQuestion",nativeQuery =  true)
    public List<Questions> findRandomQuestionsByCategory(Integer noOfQuestion, String category);
}
