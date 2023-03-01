package com.example.Phase2.service;


import dao.LoginDao;
import dao.SchoolClassDao;

import java.util.logging.Logger;

public class BaseService {
    protected static Logger logger = Logger.getLogger(BaseService.class.getName());
    protected LoginDao loginDao = new LoginDao();
    protected SchoolClassDao schoolClassDao = new SchoolClassDao();

}
