package com.example.Phase2.service;


import com.example.Phase2.dao.LoginDao;
import com.example.Phase2.dao.SchoolClassDao;

import java.util.logging.Logger;

public class BaseService {
    protected static Logger logger = Logger.getLogger(BaseService.class.getName());
    protected LoginDao loginDao = new LoginDao();
    protected SchoolClassDao schoolClassDao = new SchoolClassDao();

}
