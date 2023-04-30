package com.example.sportyShoes.controller;

import com.example.sportyShoes.constants.Result;
import com.example.sportyShoes.model.Login;
import com.example.sportyShoes.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Slf4j
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String open(Model mm, HttpSession session) {
        session.removeAttribute("emailId");
        return "index";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(@ModelAttribute Login login, Model model, HttpSession session) {
        log.info("[signIn] start! login={}", login);
        Result result = loginService.signIn(login);

        if(result.equals(Result.CUSTOMER_LOGIN_SUCCESSFULLY)) {
            session.setAttribute("emailId", login.getEmailId());
            return "redirect:/customerHome";
        }else if(result.equals(Result.ADMIN_LOGIN_SUCCESSFULLY)) {
            return "redirect:/adminHome";
        }else {
            model.addAttribute("errorMessage", result.getResultMessage());
            return "index";
        }
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(@ModelAttribute Login login, Model model, HttpSession session) {
        log.info("[signUp] start! login={}", login);

        Result result = loginService.signUp(login);
        if(result.equals(Result.ACCOUNT_CREATED_SUCCESSFULLY)) {
            session.setAttribute("emailid", login.getEmailId());
            return "customerHome";
        }
        model.addAttribute("errorMessage", result.getResultMessage());
        return "signUpPage";
    }


}