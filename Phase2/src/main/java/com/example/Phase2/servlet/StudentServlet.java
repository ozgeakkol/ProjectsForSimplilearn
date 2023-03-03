package com.example.Phase2.servlet;

import com.example.Phase2.entity.Student;
import com.example.Phase2.entity.Teacher;
import com.example.Phase2.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends HttpServlet {

    private StudentService studentService = new StudentService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        List<Student> students = studentService.getAllStudent();

        request.setAttribute("students", students);
        request.getRequestDispatcher("viewStudent.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String studentName = request.getParameter("studentName");
        String studentSurname = request.getParameter("studentSurname");

        boolean isAdded = studentService.addNewStudent(studentName, studentSurname);

        if (isAdded) {
            request.setAttribute("infoMessage", "Student added!");
        } else {
            request.setAttribute("errorMessage", "Student cannot be added!");
        }
        request.getRequestDispatcher("addStudent.jsp").forward(request, response);

    }
}
