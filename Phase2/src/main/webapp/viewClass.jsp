<%@ page import="com.example.Phase2.entity.SchoolClass" %>
<%@ page import="java.util.List" %><%--
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
<h1>You can view class in here!</h1>
    <div class=center">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                </tr>
                </thead>
                <tbody>
                <% List<SchoolClass> schoolClasses = (List<SchoolClass>) request.getAttribute("schoolClasses");
                    for (SchoolClass schoolClass : schoolClasses) { %>
                <tr>
                    <td><%= schoolClass.getId() %>
                    </td>
                    <td><%= schoolClass.getName() %>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
    </div>
</body>
</html>
