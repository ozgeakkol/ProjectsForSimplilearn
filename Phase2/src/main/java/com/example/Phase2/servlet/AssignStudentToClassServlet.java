package com.example.Phase2.servlet;

import com.example.Phase2.entity.SchoolClass;
import com.example.Phase2.entity.Student;
import com.example.Phase2.service.SchoolClassService;
import com.example.Phase2.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AssignStudentToClassServlet extends HttpServlet {

    private StudentService studentService = new StudentService();
    private SchoolClassService schoolClassService = new SchoolClassService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        List<Student> students = studentService.getAllStudent();
        List<SchoolClass> schoolClasses = schoolClassService.getAllClass();

        request.setAttribute("students", students);
        request.setAttribute("schoolClasses", schoolClasses);
        request.getRequestDispatcher("assignStudentToClass.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int classId = Integer.parseInt(request.getParameter("classId"));

        boolean isAdded = studentService.assignStudentToClass(studentId, classId);
        List<Student> students = studentService.getAllStudent();
        List<SchoolClass> schoolClasses = schoolClassService.getAllClass();

        if (isAdded) {
            request.setAttribute("infoMessage", "Student assigned!");
            request.setAttribute("students", students);
            request.setAttribute("schoolClasses", schoolClasses);
        } else {
            request.setAttribute("errorMessage", "Student cannot be assigned!");
            request.setAttribute("students", students);
            request.setAttribute("schoolClasses", schoolClasses);
        }
        request.getRequestDispatcher("assignStudentToClass.jsp").forward(request, response);

    }
}
