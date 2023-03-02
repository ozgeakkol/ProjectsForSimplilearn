package com.example.Phase2.servlet;

import com.example.Phase2.entity.SchoolClass;
import com.example.Phase2.service.SchoolClassService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ClassServlet extends HttpServlet {

    private SchoolClassService schoolClassService = new SchoolClassService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        List<SchoolClass> schoolClasses = schoolClassService.getAllClass();

        request.setAttribute("schoolClasses", schoolClasses);
        request.getRequestDispatcher("viewClass.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String className = request.getParameter("className");
        int classId = Integer.parseInt(request.getParameter("classId"));

        boolean isAdded = schoolClassService.addNewSchoolClass(classId, className);

        if (isAdded) {
            request.setAttribute("infoMessage", "Class added!");
        } else {
            request.setAttribute("errorMessage", "Class cannot be added!");
        }
        request.getRequestDispatcher("addClass.jsp").forward(request, response);

    }
}