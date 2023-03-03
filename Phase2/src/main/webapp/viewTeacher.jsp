<%@ page import="com.example.Phase2.entity.SchoolClass" %>
<%@ page import="java.util.List" %>
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
    <title>View Teacher</title>
    <link rel="stylesheet" href="stylesheets/viewClass.css">
</head>
<body>
<h1>You can view teacher in here!</h1>

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
            </tr>
            </thead>
            <tbody>
            <% List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
                for (Teacher teacher : teachers) { %>
            <tr>
                <td><%= teacher.getTeacherId() %>
                </td>
                <td><%= teacher.getTeacherName() %>
                </td>
                <td><%= teacher.getTeacherSurname() %>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
