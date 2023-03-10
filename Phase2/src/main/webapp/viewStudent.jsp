<%@ page import="com.example.Phase2.entity.SchoolClass" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Phase2.entity.Teacher" %>
<%@ page import="com.example.Phase2.entity.Student" %>
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
    <title>View Teacher</title>
    <link rel="stylesheet" href="stylesheets/viewClass.css">
</head>
<body>
<h1>You can view student in here!</h1>

    <a href="home.jsp">
        Back To Home Page
    </a>
    <div class="center">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Class</th>
            </tr>
            </thead>
            <tbody>
            <% List<Student> students = (List<Student>) request.getAttribute("students");
                for (Student student : students) { %>
            <tr>
                <td><%= student.getStudentId() %>
                </td>
                <td><%= student.getStudentName() %>
                </td>
                <td><%= student.getStudentSurname() %>
                </td>
                <%if(Objects.nonNull(student.getSchoolClass())){%>
                <td><%= student.getSchoolClass().getClassName() %></td>
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
