package com.example.Phase2.servlet;

import com.example.Phase2.service.LoginService;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginService loginService = new LoginService();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(loginService.checkUserEmail(email)){
            if(loginService.checkUserPassword(email, password)){
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
            else{
                request.setAttribute("errorMessage", "Invalid password!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("errorMessage", "Invalid email!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

    public void destroy() {
    }
}