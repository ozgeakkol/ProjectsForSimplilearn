package com.example.Phase2.servlet;

import com.example.Phase2.entity.SchoolClass;
import com.example.Phase2.entity.Subject;
import com.example.Phase2.service.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SubjectServlet extends HttpServlet {

    private SubjectService subjectService = new SubjectService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        List<Subject> subjects = subjectService.getAllClass();

        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("viewSubject.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String subjectName = request.getParameter("subjectName");

        boolean isAdded = subjectService.addNewSubject(subjectName);

        if (isAdded) {
            request.setAttribute("infoMessage", "Subject added!");
        } else {
            request.setAttribute("errorMessage", "Subject cannot be added!");
        }
        request.getRequestDispatcher("addSubject.jsp").forward(request, response);

    }
}
