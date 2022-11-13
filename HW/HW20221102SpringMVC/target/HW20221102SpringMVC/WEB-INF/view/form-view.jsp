<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>
</head>
<body>
<%--<h1>Enter your info!</h1>--%>

<form:form action="showInfo" method="get" modelAttribute="user">
    <fieldset><legend>Registration form</legend>
        <div>
            <form:label path="firstName">First name</form:label>
            <form:input path="firstName" />
            <form:errors path="firstName"/>
        </div>
        <div>
            <form:label path="lastName">Last name</form:label>
            <form:input path="lastName" />
            <form:errors path="lastName"/>
        </div>
        <div>
            <form:label path="birthday">Birthday</form:label>
            <form:input path="birthday" type="date" />
<%--        <label for="birthday">Birthday</label>--%>
<%--        <input id="birthday" type="date" name="birthday" value="${userDob}"/>--%>
        </div>
        <fieldset><legend>Gender</legend>
            <div id="genderClass">
<%--                <form:label path="gender">Gender</form:label>--%>
                <form:radiobuttons path="gender" items="${genderList}" />
            </div>
                <form:errors path="gender"/>
        </fieldset>
        <div>
            <form:label path="email">email</form:label>
            <form:input path="email" type="email" />
            <form:errors path="email"/>
        </div>
        <div>
            <form:label path="phone">phone</form:label>
            <form:input path="phone" type="phone" />
            <form:errors path="phone"/>
        </div>
        <fieldset><legend>Communication language</legend>
            <div>
<%--                <form:label path="languages">Communication language</form:label>--%>
                <form:checkboxes path="languages" items="${languagesList}" />
            </div>
            <form:errors path="languages"/>
        </fieldset>
        <div>
            <form:label path="informationSource">How did you hear about us</form:label>
            <form:select path="informationSource" id="inputInfo">
                <form:options items="${infoSources}"/>
            </form:select>
            <form:errors path="informationSource"/>
        </div>

        <div>
            <input type="submit" value="SEND">
        </div>
    </fieldset>
</form:form>

</body>
</html>
