package com.example.Phase2.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int subjectId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "classId")
    private SchoolClass schoolClass;
}

