package com.example.Phase2.servlet;

import com.example.Phase2.entity.SchoolClass;
import com.example.Phase2.entity.Student;
import com.example.Phase2.entity.Teacher;
import com.example.Phase2.service.SchoolClassService;
import com.example.Phase2.service.StudentService;
import com.example.Phase2.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AssignTeacherToClassServlet extends HttpServlet {

    private TeacherService teacherService = new TeacherService();
    private SchoolClassService schoolClassService = new SchoolClassService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        List<Teacher> teachers = teacherService.getAllTeacher();
        List<SchoolClass> schoolClasses = schoolClassService.getAllClass();

        request.setAttribute("teachers", teachers);
        request.setAttribute("schoolClasses", schoolClasses);
        request.getRequestDispatcher("assignTeacherToClass.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int teacherId = Integer.parseInt(request.getParameter("teacherId"));
        int classId = Integer.parseInt(request.getParameter("classId"));

        boolean isAdded = teacherService.assignTeacherToClass(teacherId, classId);
        List<Teacher> teachers = teacherService.getAllTeacher();
        List<SchoolClass> schoolClasses = schoolClassService.getAllClass();

        if (isAdded) {
            request.setAttribute("infoMessage", "Teacher assigned!");
            request.setAttribute("teachers", teachers);
            request.setAttribute("schoolClasses", schoolClasses);
        } else {
            request.setAttribute("errorMessage", "Teacher cannot be assigned!");
            request.setAttribute("teachers", teachers);
            request.setAttribute("schoolClasses", schoolClasses);
        }
        request.getRequestDispatcher("assignTeacherToClass.jsp").forward(request, response);

    }
}
