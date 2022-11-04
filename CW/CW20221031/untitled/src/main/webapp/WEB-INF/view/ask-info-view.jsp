<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Enter your name!</h1>
<%--<form action="showName" method="get">--%>
<%--    <input type="text" name="firstName" placeholder="Write your name"/>--%>
<%--    <input type="submit"/>--%>
<%--</form>--%>

    <form:form action="showInfo" method="get" modelAttribute="user">
        FIRST NAME <form:input  path="firstName"/>
        <form:errors path="firstName" />
        <br>
        LAST NAME <form:input  path="lastName"/>
        <form:errors path="lastName" />
        <br>
        AGE <form:input  path="age"/>
        <form:errors path="age" />
        <br>
<%--        CITY <form:select path="city">--%>
<%--                <form:option value="Dnepr" label="Dn"/>--%>
<%--                <form:option value="Mariupol" label="Mr"/>--%>
<%--                <form:option value="Chornobaevka" label="Chb"/>--%>
<%--            </form:select>--%>

        CITY <form:select path="city">
                <form:options items="${user.cities}" />
            </form:select>

        <br>
        GENDER
        <form:radiobuttons path="gender" items="${user.genders}"/>
        <br>
        LANGUAGES
        <form:checkboxes path="language" items="${user.languages}"/>
        <br>
        <input type="submit" value="SEND"/>
    </form:form>

</body>
</html>
