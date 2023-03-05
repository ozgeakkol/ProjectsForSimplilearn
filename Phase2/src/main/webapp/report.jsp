<%@ page import="com.example.Phase2.entity.SchoolClass" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Phase2.domain.ClassReport" %>
<%@ page import="com.example.Phase2.entity.Student" %>
<%@ page import="com.example.Phase2.entity.Subject" %>
<%@ page import="com.example.Phase2.entity.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: ozge
  Date: 1.03.2023
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Class</title>
    <link rel="stylesheet" href="stylesheets/viewClass.css">
</head>
<body>
<h1>You can view class report in here!</h1>

<a href="home.jsp">
    Back To Home Page
</a>
<div class="center">

    <%ClassReport classReport = (ClassReport) request.getAttribute("schoolClassReport");%>
    <label>Class Id: </label>
    <span><%=classReport.getSchoolClass().getClassId()%></span>
    <br><br>
    <label>Class Name: </label>
    <span><%=classReport.getSchoolClass().getClassName()%></span>
    <br><br>
    <label>Students: </label>
    <%
        for(Student student : classReport.getStudents()){%>
            <span><%=student.getStudentName() + " " + student.getStudentSurname()%></span>
        <%}%>
    <br><br>
    <label>Teachers: </label>
    <%
        for(Teacher teacher : classReport.getTeachers()){%>
    <span><%=teacher.getTeacherName() + " " + teacher.getTeacherSurname()%></span>
    <%}%>
    <br><br>
    <label>Subjects: </label>
    <%
        for(Subject subject : classReport.getSubjects()){%>
    <span><%=subject.getSubjectName() %></span>
    <%}%>

</div>
</body>
</html>
