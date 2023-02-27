package com.example.Phase2;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class LoginServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email.equals("admin@domain.com") && password.equals("123")) {
            request.setAttribute("email", email);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid username or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}