package com.example.Phase2.service;

import com.example.Phase2.entity.SchoolClass;
import com.example.Phase2.entity.Teacher;

import java.util.List;
import java.util.Objects;

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
            logger.info("Exception occurred! " +e);
            return false;
        }
    }

    public List<Teacher> getAllTeacher() {
        return teacherDao.getAll();
    }

    public boolean assignTeacherToClass(int teacherId, int classId){
        Teacher teacher = teacherDao.getTeacherById(teacherId);
        SchoolClass schoolClass = schoolClassDao.getSchoolClassById(classId);

        if(Objects.nonNull(teacher) && Objects.nonNull(schoolClass)){
            return teacherDao.assignTeacherToClass(teacher, schoolClass);
        }
        return false;
    }
}
