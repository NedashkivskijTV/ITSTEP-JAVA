<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%--<style>--%>
<%--    form{--%>
<%--        background-color: coral;--%>
<%--    }--%>
<%--</style>--%>
<link>
    <title>Form</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>
</head>
<body>
<form action="showUserInfo" method="get">
    <fieldset><legend>Анкета</legend>
        <div>
            <label for="surname">Фамилия</label>
            <input id="surname" type="text" name="surname" maxlength="50" placeholder="Last name">
        </div>
        <div>
            <label for="name">Имя</label>
            <input id="name" type="text" name="name" maxlength="50" placeholder="First name">
        </div>
        <div>
            <label for="birthday">Дата рождения</label>
            <input id="birthday" type="date" name="birthday">
        </div>
        <div>
            <label for="email">Email</label>
            <input id="email" type="email" name="email" placeholder="exemple@domain.com">
        </div>
        <div>
            <label for="phone">Телефон</label>
            <input id="phone" type="phone" name="phone" placeholder="+380771234567">
        </div>
        <hr>
        <div>
            <input type="submit" name="noname" value="Save">
        </div>
    </fieldset>
</form>
</body>
</html>
