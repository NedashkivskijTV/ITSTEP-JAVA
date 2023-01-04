<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create-update</title>
</head>
<body>
    <form:form action="saveEmployee" modelAttribute="employee">
        <form:hidden path="id"/>
        FirstName: <form:input path="firstName"/>
        <br/>
        LastName: <form:input path="lastName"/>
        <br/>
        Department: <form:input path="department"/>
        <br/>
        Salary: <form:input path="salary"/>
        <br/>
        <input type="submit" value="OK">
    </form:form>
</body>
</html>
