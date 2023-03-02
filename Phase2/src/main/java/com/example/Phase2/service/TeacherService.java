package com.example.Phase2.service;

import com.example.Phase2.entity.Teacher;

import java.util.List;

public class TeacherService extends BaseService{

    public boolean addNewTeacher(String teacherName, String teacherSurname) {
        try{
            Teacher teacher = Teacher.builder().teacherName(teacherName).teacherSurname(teacherSurname).build();
            if(!teacherDao.isExist(teacher)){
                boolean isInserted = teacherDao.insert(teacher);
                return isInserted;
            }
            return false;
        }catch (Exception e){
            //todo: change log status
            logger.info("Exception occurred! " +e);
            return false;
        }
    }

    public List<Teacher> getAllTeacher() {
        return teacherDao.getAll();
    }
}
