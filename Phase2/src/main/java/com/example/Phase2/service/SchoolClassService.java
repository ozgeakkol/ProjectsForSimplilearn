package com.example.Phase2.service;

import com.example.Phase2.entity.SchoolClass;
import java.util.List;

public class SchoolClassService extends BaseService{

    public boolean addNewSchoolClass(int id, String name){
        try{
            SchoolClass schoolClass = SchoolClass.builder().classId(id).className(name).build();
            if(!schoolClassDao.isExist(schoolClass)){
                boolean isInserted = schoolClassDao.insert(schoolClass);
                return isInserted;
            }
            return false;
        }catch (Exception e){
            //todo: change log status
            logger.info("Exception occurred! " +e);
            return false;
        }
    }

    public List<SchoolClass> getAllClass(){
       return schoolClassDao.getAll();
    }
}
