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
    <link rel="stylesheet" href="stylesheets/home.css">
</head>
<body>
    <div class="center">
        <a href="addClass.jsp" class="aToButton">Add Class</a>
        <a href="/viewClass" class="aToButton">View Class</a>
        <br>
        <a href="addSubject.jsp" class="aToButton">Add Subject</a>
        <a href="/viewSubject" class="aToButton">View Subject</a>
        <br>
        <a href="addTeacher.jsp" class="aToButton">Add Teacher</a>
        <a href="/viewTeacher" class="aToButton">View Teacher</a>
        <br>
        <a href="addStudent.jsp" class="aToButton">Add student</a>
        <a href="/viewStudent" class="aToButton">View Student</a>

        <br>
        <hr>

        <a href="/assignStudentToClass" class="aToButton">Assign Student To Class</a>
        <br>
        <a href="/assignTeacherToClass" class="aToButton">Assign Teacher To Class</a>
        <br>
        <a href="/assignSubjectToClass" class="aToButton">Assign Subject To Class</a>
        <br>
       <!-- <a href="/assignSubjectToTeacher" class="aToButton">Assign Subject To Teacher</a>
        <br>-->
        <a href="/viewClassReport" class="aToButton">Class Report</a>
    </div>

</body>
</html>
