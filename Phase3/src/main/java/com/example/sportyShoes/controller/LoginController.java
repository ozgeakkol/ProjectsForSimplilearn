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

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String open(Model mm) {
        mm.addAttribute("login", new Login());
        return "index";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(@ModelAttribute Login login, Model model) {
        System.out.println("login!!!------" + login);
        log.info("[signIn] start! login={}", login);
        String result = loginService.signIn(login);

        if(result.equals("Customer login successfully")) {
            return "customerHome";
        }else if(result.equals("Admin login successfully")) {
            return "adminHome";
        }else {
            return "index";
        }
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUp(Model model){
        model.addAttribute("login", new Login());
        return "signUp";
    }
}