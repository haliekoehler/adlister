<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />

    <div>
        <h1>Welcome ${user}!</h1>
    </div>

    <div class="container">
        <h3>Viewing your profile.</h3>
    </div>


</body>
</html>
