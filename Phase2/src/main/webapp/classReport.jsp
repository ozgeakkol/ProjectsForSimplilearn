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
    <title>Class</title>
    <link rel="stylesheet" href="stylesheets/viewClass.css">
</head>
<body>
<h1>You can view class report in here!</h1>

    <a href="home.jsp">
        Back To Home Page
    </a>
    <div class="center">

        <form action="/viewReport" method="post">
            <label>Class Name: </label>
            <select name="classId" required>
                <option value="" disabled selected>Select an option</option>
                <%List<SchoolClass> schoolClasses = (List<SchoolClass>) request.getAttribute("schoolClasses");
                    for(SchoolClass schoolClass : schoolClasses){ %>
                <option value="<%=schoolClass.getClassId()%>"><%=schoolClass.getClassName()%></option>
                <%}%>
            </select>
            <br><br>
            <button type="submit">Get Class Report</button>
        </form>


    </div>
</body>
</html>
