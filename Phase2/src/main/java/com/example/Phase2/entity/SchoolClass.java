package com.example.Phase2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "school_class")
public class SchoolClass {

    @Id
    @Column(name = "id")
    private int classId;

    private String name;

    @OneToMany
    @JoinColumn(name = "id")
    private List<Student> students;

    @OneToMany
    @JoinColumn(name = "id")
    private List<Subject> subjects;
}
