<%@ page import="com.example.Phase2.entity.SchoolClass" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Phase2.entity.Subject" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: ozge
  Date: 1.03.2023
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Class</title>
    <link rel="stylesheet" href="stylesheets/viewClass.css">
</head>
<body>
<h1>You can view subjects in here!</h1>

    <a href="home.jsp">
        Back To Home Page
    </a>
    <div class="center">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Class</th>
                <th>Teacher</th>
            </tr>
            </thead>
            <tbody>
            <% List<Subject> subjects = (List<Subject>) request.getAttribute("subjects");
                for (Subject subject : subjects) { %>
            <tr>
                <td><%= subject.getSubjectId() %>
                </td>
                <td><%= subject.getSubjectName() %>
                </td>
                <%if(Objects.nonNull(subject.getSchoolClass())){%>
                <td><%= subject.getSchoolClass().getClassName() %></td>
                <%}else{%>
                <td></td>
                <%}%>
                <%if(Objects.nonNull(subject.getTeacher())){%>
                <td><%= subject.getTeacher().getTeacherName() + " " + subject.getTeacher().getTeacherSurname() %></td>
                <%}else{%>
                <td></td>
                <%}%>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
