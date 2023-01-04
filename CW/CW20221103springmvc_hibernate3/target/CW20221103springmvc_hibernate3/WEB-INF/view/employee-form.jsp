<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Taras
  Date: 27.12.2022
  Time: 5:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="saveEmployee" modelAttribute="employee">
        <form:hidden path="id"/>
        FirstName: <form:input path="firstName" />
        <br>
        LastName: <form:input path="lastName" />
        <br>
        Department: <form:input path="department" />
        <br>
        Salary: <form:input path="salary" />
        <br>
        <input type="submit" value="OK">
    </form:form>
</body>
</html>
