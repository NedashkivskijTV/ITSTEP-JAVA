<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<%--    <link rel="stylesheet" href="style.css" />--%>
<%--    <link rel="stylesheet" th:href="@{/css/bootstrap.min.css}" />--%>
    <title>Title</title>
<%--    <link href="${pageContext.request.contextPath}/static/style.css" rel="stylesheet" >--%>
    <link href="<c:url value='/static/style.css' />" rel="stylesheet" />
</head>
<body>
<%--    <h1 style="color: red">I like Java !</h1>--%>
    <h1 id="java">I like Java !</h1>
    <a href="askName">Enter your name</a>
</body>
</html>
