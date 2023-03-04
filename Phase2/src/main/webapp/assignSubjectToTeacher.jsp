<%@ page import="java.util.List" %>
<%@ page import="com.example.Phase2.entity.Student" %>
<%@ page import="com.example.Phase2.entity.SchoolClass" %>
<%@ page import="com.example.Phase2.entity.Subject" %>
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
    <title>Assign Subject To Teacher</title>
    <link rel="stylesheet" href="stylesheets/viewClass.css">
</head>
<h1>You can assign subject to teacher in here!</h1>
<body>

    <a href="home.jsp">
        Back To Home Page
    </a>
    <div class="center">

        <br><br>
        <form action="/assignSubjectTeacher" method="post">

            <label>Subject: </label>
            <select name="subjectId" required>
                <option value="" disabled selected>Select an option</option>
                <%List<Subject> subjects = (List<Subject>) request.getAttribute("subjects");
                    for(Subject subject : subjects){ %>
                <option value="<%=subject.getSubjectId()%>"><%=subject.getSubjectName()%></option>
                <%}%>
            </select>

            <br><br>
            <label>Teacher Name: </label>
            <select name="teacherId" required>
                <option value="" disabled selected>Select an option</option>
                <%List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
                    for(Teacher teacher : teachers){ %>
                <option value="<%=teacher.getTeacherId()%>"><%=teacher.getTeacherName() + " " + teacher.getTeacherSurname()%></option>
                <%}%>
            </select>
            <br><br>
            <button name="assign-subject-to-teacher" type="submit">Assign Subject To Teacher</button>

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
