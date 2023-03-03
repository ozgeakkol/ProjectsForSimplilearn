<%@ page import="java.util.List" %>
<%@ page import="com.example.Phase2.entity.Student" %>
<%@ page import="com.example.Phase2.entity.SchoolClass" %><%--
  Created by IntelliJ IDEA.
  User: ozge
  Date: 3.03.2023
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assign Student To Class</title>
    <link rel="stylesheet" href="stylesheets/viewClass.css">
</head>
<h1>You can assign student to class in here!</h1>
<body>
    <div class="center">

        <a href="home.jsp">
            Back To Home Page
        </a>

        <br><br>
        <form action="/assignStudent" method="post">

            <label>Student: </label>
            <select name="studentId" required>
                <option value="" disabled selected>Select an option</option>
                <%List<Student> students = (List<Student>) request.getAttribute("students");
                    for(Student student : students){ %>
                <option value="<%=student.getStudentId()%>"><%=student.getStudentName() + " " + student.getStudentSurname()%></option>
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
            <button name="assign-student-to-class" type="submit">Assign Student To Class</button>

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
