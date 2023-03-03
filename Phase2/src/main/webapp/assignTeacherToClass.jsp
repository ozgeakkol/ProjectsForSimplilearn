<%@ page import="java.util.List" %>
<%@ page import="com.example.Phase2.entity.Student" %>
<%@ page import="com.example.Phase2.entity.SchoolClass" %>
<%@ page import="com.example.Phase2.entity.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: ozge
  Date: 3.03.2023
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assign Teacher To Class</title>
    <link rel="stylesheet" href="stylesheets/viewClass.css">
</head>
<h1>You can assign teacher to class in here!</h1>
<body>
    <div class="center">

        <a href="home.jsp">
            Back To Home Page
        </a>

        <br><br>
        <form action="/assignTeacher" method="post">

            <label>Teacher: </label>
            <select name="teacherId" required>
                <option value="" disabled selected>Select an option</option>
                <%List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
                    for(Teacher teacher : teachers){ %>
                <option value="<%=teacher.getTeacherId()%>"><%=teacher.getTeacherName() + " " + teacher.getTeacherSurname()%></option>
                <%}%>
            </select>

            <br><br>
            <label>Class Name: </label>
            <select name="classId" required>
                <option value="" disabled selected>Select an option</option>
                <%List<SchoolClass> schoolClasses = (List<SchoolClass>) request.getAttribute("schoolClasses");
                    for(SchoolClass schoolClass : schoolClasses){ %>
                <option value="<%=schoolClass.getClassId()%>"><%=schoolClass.getClassName()%></option>
                <%}%>
            </select>
            <br><br>
            <button name="assign-teacher-to-class" type="submit">Assign Teacher To Class</button>

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
