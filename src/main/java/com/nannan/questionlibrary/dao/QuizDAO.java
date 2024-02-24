package com.nannan.questionlibrary.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nannan.questionlibrary.model.Quiz;

@Repository
public interface QuizDAO extends JpaRepository<Quiz,Integer>{
}
