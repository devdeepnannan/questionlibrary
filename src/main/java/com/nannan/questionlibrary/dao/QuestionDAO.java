package com.nannan.questionlibrary.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nannan.questionlibrary.model.Questions;

@Repository
public interface QuestionDAO extends JpaRepository<Questions, Integer>{
    
}
