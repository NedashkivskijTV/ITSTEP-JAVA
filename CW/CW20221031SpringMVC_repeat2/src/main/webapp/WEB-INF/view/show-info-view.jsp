<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Info</title>
</head>
<body>
<h1>Welcome!</h1>
<div>
  FirstName: ${user.firstName}
</div>
<div>
  LastName: ${user.lastName}
</div>
<div>
  Age: ${user.age}
</div>
<div>
  City: ${user.city}
</div>
<div>
  Gender: ${user.gender}
</div>
<div>
<%--  Languages: ${userWasSent.languages}--%>
  Languages:
  <ul>
    <c:forEach var="lang" items="${user.languages}">
        <li>${lang}</li>
    </c:forEach>
  </ul>
</div>
</body>
</html>
