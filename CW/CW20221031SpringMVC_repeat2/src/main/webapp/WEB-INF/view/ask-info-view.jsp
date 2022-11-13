<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
<%--    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>--%>
</head>
<body>
<h1>Enter your info!</h1>

    <form:form action="showInfo" method="get" modelAttribute="user">
        FIRST NAME <form:input path="firstName"/>
        <form:errors path="firstName"/>
        <br/>
        LAST NAME <form:input path="lastName"/>
        <form:errors path="lastName"/>
        <br/>
        AGE <form:input path="age"/>
        <form:errors path="age"/>
        <br/>

<%--        ------- HARDCODE ---------%>
<%--        CITY <form:select path="city">--%>
<%--                <form:option value="Dnopro" label="Dn"/>--%>
<%--                <form:option value="Mariupol" label="Mr"/>--%>
<%--                <form:option value="Chornobaivka" label="Chb"/>--%>
<%--                <form:option value="Zhytomyr" label="Zt"/>--%>
<%--             </form:select>--%>

<%--        ------- NORMALCODE))) ---------%>
        CITY <form:select path="city">
<%--                використання для передачі даних до випадаючого списку поля в класі User - надмірність (избыточность)--%>
<%--                <form:options items="${userToSent.cities}"/>--%>

<%--                використання для передачі даних до випадаючого списку окремого об'єкта за ключем citiesList --%>
                <form:options items="${citiesList}"/>
<%--                <form:options items="${user.cities}"/>--%>
            </form:select>
        <br/>
<%--        ------- NORMALCODE))) ---------%>
        GENDER <form:radiobuttons path="gender" items="${gendersList}" />
<%--        GENDER <form:radiobuttons path="gender" items="${user.genders}" />--%>
        <form:errors path="gender"/>
        <br/>
<%--        ------- NORMALCODE))) ---------%>
        LANGUAGE <form:checkboxes path="languages" items="${languagesList}"/>
<%--        LANGUAGE <form:checkboxes path="languages" items="${user.languagesList}"/>--%>

        
        <br/>
        <input type="submit" value="SEND"/>
        <br/>
    </form:form>

</body>
</html>
