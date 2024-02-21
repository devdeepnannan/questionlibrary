package com.nannan.questionlibrary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "questions", schema = "public")
public class Questions {
    @Id
    @Column(name="ID")
    private Integer id;

    private String Category;
    private String difficulty;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
}
