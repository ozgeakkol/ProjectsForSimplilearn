package com.example.Phase2.servlet;

import com.example.Phase2.domain.ClassReport;
import com.example.Phase2.entity.SchoolClass;
import com.example.Phase2.entity.Teacher;
import com.example.Phase2.service.SchoolClassService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ClassReportServlet extends HttpServlet {
    private SchoolClassService schoolClassService = new SchoolClassService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        List<SchoolClass> schoolClasses = schoolClassService.getAllClass();

        request.setAttribute("schoolClasses", schoolClasses);
        request.getRequestDispatcher("classReport.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        int classId = Integer.parseInt(request.getParameter("classId"));

        ClassReport schoolClassReport= schoolClassService.getClassReportById(classId);

        request.setAttribute("schoolClassReport", schoolClassReport);
        request.getRequestDispatcher("report.jsp").forward(request, response);

    }
}
