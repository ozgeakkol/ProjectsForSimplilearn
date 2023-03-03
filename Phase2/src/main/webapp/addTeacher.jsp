<%--
  Created by IntelliJ IDEA.
  User: ozge
  Date: 1.03.2023
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Teacher</title>
    <link rel="stylesheet" href="stylesheets/addClass.css">
</head>
<body>
    <h1>You can add teacher in here!</h1>
    <a href="home.jsp">
        Back To Home Page
    </a>

    <div class="center">

        <form action="/addTeacher" method="post">
            <label>Teacher Name: </label>
            <input name="teacherName"/>
            <br><br>
            <label>Teacher Surname: </label>
            <input name="teacherSurname"/>
            <br><br>
            <button name="add-teacher" type="submit">Add Teacher</button>
            <br><br>
            <%
                Object message = request.getAttribute("infoMessage");
                if (message != null) { %>
            <span style="color:red;"><%=message.toString()%></span>
            <%}%>
            <%
                Object errorMessage = request.getAttribute("errorMessage");
                if (errorMessage != null) { %>
            <span style="color:red;"><%=errorMessage.toString()%></span>
            <%}%>

        </form>
    </div>
</body>
</html>
