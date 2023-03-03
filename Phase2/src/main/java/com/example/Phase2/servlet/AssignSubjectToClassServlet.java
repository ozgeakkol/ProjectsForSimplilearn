package com.example.Phase2.servlet;

import com.example.Phase2.entity.SchoolClass;
import com.example.Phase2.entity.Student;
import com.example.Phase2.entity.Subject;
import com.example.Phase2.service.SchoolClassService;
import com.example.Phase2.service.StudentService;
import com.example.Phase2.service.SubjectService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class AssignSubjectToClassServlet extends HttpServlet {

    private SubjectService subjectService = new SubjectService();
    private SchoolClassService schoolClassService = new SchoolClassService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        List<Subject> subjects = subjectService.getAllSubject();
        List<SchoolClass> schoolClasses = schoolClassService.getAllClass();

        request.setAttribute("subjects", subjects);
        request.setAttribute("schoolClasses", schoolClasses);
        request.getRequestDispatcher("assignSubjectToClass.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        int classId = Integer.parseInt(request.getParameter("classId"));

        boolean isAdded = subjectService.assignSubjectToClass(subjectId, classId);
        List<Subject> subjects = subjectService.getAllSubject();
        List<SchoolClass> schoolClasses = schoolClassService.getAllClass();

        if (isAdded) {
            request.setAttribute("infoMessage", "Subject assigned!");
            request.setAttribute("subjects", subjects);
            request.setAttribute("schoolClasses", schoolClasses);
        } else {
            request.setAttribute("errorMessage", "Subject cannot be assigned!");
            request.setAttribute("subjects", subjects);
            request.setAttribute("schoolClasses", schoolClasses);
        }
        request.getRequestDispatcher("assignSubjectToClass.jsp").forward(request, response);

    }
}
