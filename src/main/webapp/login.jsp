<%--
  Created by IntelliJ IDEA.
  User: HKoehler
  Date: 1/30/17
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="partials/navbar.jsp" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="POST" action="login.jsp">
    <p>
        <label for="username">Username</label>
        <input id="username" name="username" type="text">
    </p>
    <p>
        <label for="password">Password</label>
        <input id="password" name="password" type="password">
    </p>
    <p>
        <input type="submit">
    </p>
</form>
</body>
</html>
