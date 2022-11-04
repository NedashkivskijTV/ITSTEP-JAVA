<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Welcome!</h1>
    <div>
        FIRST NAME: ${user.firstName}
    </div>
    <div>
        LAST NAME: ${user.lastName}
    </div>
    <div>
        AGE: ${user.age}
    </div>
    <div>
        CITY: ${user.city}
    </div>
    <div>
        GENDER: ${user.gender}
    </div>
<%--    <div>--%>
<%--        LANGUAGE: ${user.language}--%>
<%--    </div>--%>
    LANGUAGES
    <ul>
        <c:forEach var="lang" items="${user.language}">
            <li>${lang}</li>
        </c:forEach>
    </ul>
</body>
</html>
