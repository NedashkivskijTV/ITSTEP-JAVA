<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
</head>
<body>
<h2>Check the entered data :</h2>
<div>
    User firstname : ${user.firstName}
</div>
<div>
    User lastname : ${user.lastName}
</div>
<div>
    User birthday : ${user.birthday}
</div>
<div>
    User gender : ${user.gender}
</div>
<div>
    User email : ${user.email}
</div>
<div>
    User phone : ${user.phone}
</div>
<div>
    Communication language :
    <ul>
        <c:forEach var="lang" items="${user.languages}">
            <li>${lang}</li>
        </c:forEach>
    </ul>
</div>
<div>
    How did you hear about us : ${user.informationSource}
</div>
</body>
</html>
