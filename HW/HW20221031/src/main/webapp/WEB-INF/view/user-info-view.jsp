<%--
  Created by IntelliJ IDEA.
  User: Taras
  Date: 08.11.2022
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserInfo</title>
</head>
<body>
    <div>
        <div>
<%--            User lastname : ${param.surname}--%>
            User lastname : ${lName}
        </div>
        <div>
<%--            User firstname : ${param.name}--%>
            User firstname : ${fName}
        </div>
        <div>
<%--            User birthday : ${param.birthday}--%>
            User birthday : ${userBd}
        </div>
        <div>
            User email : ${param.email}
        </div>
        <div>
            User phone : ${param.phone}
        </div>
    </div>
</body>
</html>
