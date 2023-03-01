package com.example.Phase2.servlet;

import com.example.Phase2.service.SchoolClassService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddClassServlet extends HttpServlet {

    private SchoolClassService schoolClassService = new SchoolClassService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

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