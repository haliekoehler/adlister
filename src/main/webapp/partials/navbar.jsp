<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="../ads">Show All Ads</a></li>

            <%-- Checks if user is logged in, if so display "logout" --%>
            <c:choose>
            <c:when test='${sessionScope.containsKey("user")}'>
            <li><a href="logout">Logout</a></li>
            </c:when>
            <c:otherwise>
            <li><a href="login">Login</a></li>
            </c:otherwise>
            </c:choose>
    </div><!-- /.container-fluid -->
</nav>
