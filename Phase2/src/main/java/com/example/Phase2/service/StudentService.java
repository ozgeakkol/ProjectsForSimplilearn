package com.example.Phase2.service;

import com.example.Phase2.entity.Student;
import com.example.Phase2.entity.Teacher;

import java.util.List;

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

}
