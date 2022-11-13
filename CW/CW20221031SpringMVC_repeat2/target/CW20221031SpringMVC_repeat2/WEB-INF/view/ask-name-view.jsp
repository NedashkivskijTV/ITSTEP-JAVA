<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>
</head>
<body>
    <h1>Enter your name! - Введіть Ваше ім'я!</h1>
<form action="showName" method="get">
    <input type="text" name="firstName" placeholder="Write your name"/>
    <input type="submit"/>
</form>
</body>
</html>
