<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>Employees</h1>
    <table border="">
        <tr>
            <th>FirstName</th>
            <th>LastName</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Operations</th>
        </tr>
        <c:forEach var="employee" items="${employees}">
            <c:url var="deleteButton" value="/deleteEmployee">
                <c:param name="employeeId" value="${employee.id}"/>
            </c:url>
            <c:url var="updateButton" value="/updateEmployee">
                <c:param name="employeeId" value="${employee.id}"/>
            </c:url>
            <tr>
                 <td>${employee.firstName}</td>
                 <td>${employee.lastName}</td>
                 <td>${employee.department}</td>
                 <td>${employee.salary}</td>
                <td>
                    <input type="button" value="delete" onclick="window.location.href='${deleteButton}'"/>
                    <input type="button" value="update" onclick="window.location.href='${updateButton}'"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="button" value="create" onclick="window.location.href='createEmployee'"/>
</body>
</html>
