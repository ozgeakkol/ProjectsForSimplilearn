package com.example.Phase2.service;


import com.example.Phase2.dao.LoginDao;
import com.example.Phase2.dao.SchoolClassDao;
import com.example.Phase2.dao.SubjectDao;

import java.util.logging.Logger;

public class BaseService {
    protected static Logger logger = Logger.getLogger(BaseService.class.getName());
    protected LoginDao loginDao = new LoginDao();
    protected SchoolClassDao schoolClassDao = new SchoolClassDao();
    protected SubjectDao subjectDao= new SubjectDao();
}
