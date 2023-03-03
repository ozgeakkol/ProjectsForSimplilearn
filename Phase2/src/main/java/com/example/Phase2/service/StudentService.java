package com.example.Phase2.service;

import com.example.Phase2.entity.SchoolClass;
import com.example.Phase2.entity.Student;
import com.example.Phase2.entity.Teacher;

import java.util.List;
import java.util.Objects;

public class StudentService extends BaseService{
    public boolean addNewStudent(String studentName, String studentSurname) {
        try{
            Student student = Student.builder().studentName(studentName).studentSurname(studentSurname).build();
            if(!studentDao.isExist(student)){
                boolean isInserted = studentDao.insert(student);
                return isInserted;
            }
            return false;
        }catch (Exception e){
            //todo: change log status
            logger.info("Exception occurred! " +e);
            return false;
        }
    }

    public List<Student> getAllStudent() {
        return studentDao.getAll();
    }


    public boolean assignStudentToClass(int studentId, int classId){
        Student student = studentDao.getStudentById(studentId);
        SchoolClass schoolClass = schoolClassDao.getSchoolClassById(classId);

        if(Objects.nonNull(student) && Objects.nonNull(schoolClass)){
            return studentDao.assignStudentToClass(student, schoolClass);
        }
        return false;
    }
}
