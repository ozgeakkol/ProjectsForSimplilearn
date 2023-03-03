package com.example.Phase2.servlet;

import com.example.Phase2.entity.Subject;
import com.example.Phase2.entity.Teacher;
import com.example.Phase2.service.SubjectService;
import com.example.Phase2.service.TeacherService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class AssignSubjectToTeacherServlet extends HttpServlet {

    private SubjectService subjectService = new SubjectService();
    private TeacherService teacherService = new TeacherService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        List<Subject> subjects = subjectService.getAllSubject();
        List<Teacher> teachers = teacherService.getAllTeacher();

        request.setAttribute("subjects", subjects);
        request.setAttribute("teachers", teachers);
        request.getRequestDispatcher("assignSubjectToTeacher.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        int teacherId = Integer.parseInt(request.getParameter("teacherId"));

        boolean isAdded = subjectService.assignSubjectToTeacher(subjectId, teacherId);
        List<Subject> subjects = subjectService.getAllSubject();
        List<Teacher> teachers = teacherService.getAllTeacher();

        if (isAdded) {
            request.setAttribute("infoMessage", "Subject assigned!");
            request.setAttribute("subjects", subjects);
            request.setAttribute("teachers", teachers);
        } else {
            request.setAttribute("errorMessage", "Subject cannot be assigned!");
            request.setAttribute("subjects", subjects);
            request.setAttribute("teachers", teachers);
        }
        request.getRequestDispatcher("assignSubjectToTeacher.jsp").forward(request, response);

    }
}
