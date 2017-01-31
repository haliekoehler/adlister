<%--
  Created by IntelliJ IDEA.
  User: HKoehler
  Date: 1/31/17
  Time: 10:20 AM
  To change this template use File | Settings
  | File Templates.
--%>


<%-- ------------------------------------------------- --%>
<%-- This is an example of JSP without using a Servlet --%>
<%-- ------------------------------------------------- --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- doPost --%>
<% if (request.getMethod().equalsIgnoreCase("post")){
    String username = request.getParameter("usersname");
    String password = request.getParameter("password");

    if("adimn".equalsIgnoreCase(username) && "password".equalsIgnoreCase(password)){
        response.sendRedirect("profile.jsp");
    }
}
<%-- doGet --%>

%>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="profile.jsp" method="post">
        <label>Username</label>
        <input type="text" name="username">
        <label>Password</label>
        <input type="password" name="password">
        <input type="submit" value="login">
    </form>
</body>
</html>
