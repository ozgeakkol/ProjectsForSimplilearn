package com.example.sportyShoes.service;

import com.example.sportyShoes.constants.Result;
import com.example.sportyShoes.repository.LoginRepository;
import com.example.sportyShoes.model.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public Result signUp(Login login) {
        if(login.getTypeOfUser().equalsIgnoreCase("admin")) {
            return Result.ADMIN_ACCOUNT_CREATION_ERROR;
        }else {
            Optional<Login> result = loginRepository.findById(login.getEmailId());
            if(result.isPresent()) {
                return Result.ACCOUNT_ALREADY_PRESENT;
            }else {
                loginRepository.save(login);
                return Result.ACCOUNT_CREATED_SUCCESSFULLY;
            }
        }
    }


    public Result signIn(Login login) {
        try{
            log.info("[signIn] user will be sign in!");
            Login ll = loginRepository.signIn(login.getEmailId(), login.getPassword(), login.getTypeOfUser());
            if(ll==null) {
                log.info("[signIn] login user could not be found!");
                return Result.INVALID_EMAIL_OR_PASSWORD;
            }else {
                if(ll.getTypeOfUser().equalsIgnoreCase("admin")) {
                    log.info("[signIn] Admin login successfully!");
                    return Result.ADMIN_LOGIN_SUCCESSFULLY;
                }else {
                    log.info("[signIn] Customer login successfully!");
                    return Result.CUSTOMER_LOGIN_SUCCESSFULLY;
                }
            }
        }catch (Exception e){
            log.error("[signIn] Exception occurred!", e);
            return Result.LOGIN_ERROR;
        }
    }
}
