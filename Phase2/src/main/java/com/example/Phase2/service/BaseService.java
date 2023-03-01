package com.example.Phase2.service;


import dao.LoginDao;

import java.util.logging.Logger;

public class BaseService {
    protected static Logger logger = Logger.getLogger(BaseService.class.getName());
    protected LoginDao loginDao = new LoginDao();
}
