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
    <title>Add Subject</title>
    <link rel="stylesheet" href="stylesheets/addClass.css">
</head>
<body>
<h1>You can add subject in here!</h1>
<div class="center">
    <form action="/addSubject" method="post">

        <label>Subject: </label>
        <input name="subjectName"/>
        <br><br>
        <button name="subject-class" type="submit">Add Subject</button>

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
