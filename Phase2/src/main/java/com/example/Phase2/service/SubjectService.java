package com.example.Phase2.service;

import com.example.Phase2.entity.SchoolClass;
import com.example.Phase2.entity.Student;
import com.example.Phase2.entity.Subject;

import java.util.List;
import java.util.Objects;

public class SubjectService extends BaseService {

    public boolean addNewSubject(String subjectName) {
        try{

            Subject subject = Subject.builder().subjectName(subjectName).build();
            if(!subjectDao.isExist(subject)){
                boolean isInserted = subjectDao.insert(subject);
                return isInserted;
            }
            return false;
        }catch (Exception e){
            //todo: change log status
            logger.info("Exception occurred! " +e);
            return false;
        }
    }

    public List<Subject> getAllSubject() {
        return subjectDao.getAll();
    }

    public boolean assignSubjectToClass(int subjectId, int classId){
        Subject subject = subjectDao.getSubjectById(subjectId);
        SchoolClass schoolClass = schoolClassDao.getSchoolClassById(classId);

        if(Objects.nonNull(subject) && Objects.nonNull(schoolClass)){
            return subjectDao.assignSubjectToClass(subject, schoolClass);
        }
        return false;
    }
}
