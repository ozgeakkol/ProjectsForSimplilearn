package com.example.Phase2.servlet;

import com.example.Phase2.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TeacherServlet extends HttpServlet {

    TeacherService teacherService = new TeacherService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String teacherName = request.getParameter("teacherName");
        String teacherSurname = request.getParameter("teacherSurname");

        boolean isAdded = teacherService.addNewTeacher(teacherName, teacherSurname);

        if (isAdded) {
            request.setAttribute("infoMessage", "Teacher added!");
        } else {
            request.setAttribute("errorMessage", "Teacher cannot be added!");
        }
        request.getRequestDispatcher("addTeacher.jsp").forward(request, response);

    }
}
