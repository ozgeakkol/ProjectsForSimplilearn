<%--
  Created by IntelliJ IDEA.
  User: ozge
  Date: 23.02.2023
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body>
    <p> This is home page!</p>
    <%
        Object email = request.getAttribute("email");
        if(email!= null){ %>
    <span style="color:red;"><%=email.toString()%></span>
    <%}%>
</body>
</html>
