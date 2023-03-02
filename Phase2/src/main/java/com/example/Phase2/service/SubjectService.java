package com.example.Phase2.service;

import com.example.Phase2.entity.Subject;

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
}
