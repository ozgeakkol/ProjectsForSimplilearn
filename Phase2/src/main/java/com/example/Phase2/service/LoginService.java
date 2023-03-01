package com.example.Phase2.service;

import com.example.Phase2.entity.Login;

import java.util.List;

public class LoginService extends BaseService{

    public boolean checkUserEmail(String email){
        logger.info("[checkUserEmail] started!");
        try {
            List<Login> logins = loginDao.getLoginFromEmail(email);
            return !logins.isEmpty();
        }catch (Exception e){
            logger.info("[checkUserEmail] exception occurred!"+ e);
            return false;
        }
    }

    public boolean checkUserPassword(String email, String password){
        try{
            logger.info("[checkUserPassword] started!");
            List<Login> logins = loginDao.getLoginFromEmail(email);
            return logins.get(0).getPassword().equals(password);
        }catch (Exception e){
            logger.info("[checkUserPassword] exception occurred!"+ e);
            return false;
        }
    }
}
