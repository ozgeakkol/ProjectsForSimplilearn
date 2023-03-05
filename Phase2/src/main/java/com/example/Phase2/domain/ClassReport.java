package com.example.Phase2.domain;

import com.example.Phase2.entity.SchoolClass;
import com.example.Phase2.entity.Student;
import com.example.Phase2.entity.Subject;
import com.example.Phase2.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ClassReport {
    private SchoolClass schoolClass;
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Subject> subjects;

}
