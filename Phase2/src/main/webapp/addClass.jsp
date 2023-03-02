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
    <title>Add Class</title>
    <link rel="stylesheet" href="stylesheets/addClass.css">
</head>
<body>
    <h1>You can add class in here!</h1>
    <div class="center">
        <form action="/addClass" method="post">
            <label>Class Id:</label>
            <input name="classId"/>

            <label>Class Name: </label>
            <input name="className"/>
            <br><br>
            <button name="add-class" type="submit">Add Class</button>

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
