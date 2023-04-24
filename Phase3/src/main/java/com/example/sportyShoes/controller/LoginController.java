package com.example.sportyShoes.controller;

import com.example.sportyShoes.model.Login;
import com.example.sportyShoes.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Slf4j
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;


    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(@ModelAttribute Login login, Model model) {
        log.info("[signIn] start! login={}", login);
        String result = loginService.signIn(login);

        if(result.equals("Customer login successfully")) {
            return "customerHome";
        }else if(result.equals("Admin login successfully")) {
            return "adminHome";
        }else {
            model.addAttribute("errorMessage", result);
            return "index";
        }
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(@ModelAttribute Login login, Model model) {
        log.info("[signUp] start! login={}", login);

        //TODO: change logic
        String result = loginService.signUp(login);
        if(result.equals("Account created successfully")) {
            return "customerHome";
        }
        model.addAttribute("errorMessage", result);
        return "signUpPage";
    }


}