<%@ page import="java.util.List" %>
<%@ page import="com.example.Phase2.entity.Student" %><%--
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
</head>
<body>
    <div class="center">

        <form action="/assignStudent" method="post">

            <label>Student: </label>
            <select name="studentId">
                <%List<Student> students = (List<Student>) request.getAttribute("students");
                    for(Student student : students){ %>
                <option value="<%=student.getStudentId()%>"><%=student.getStudentName() + " " + student.getStudentSurname()%></option>
                <%}%>
            </select>

            <br><br>
            <label>Class Id: </label>
            <input name="classId"/>
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
