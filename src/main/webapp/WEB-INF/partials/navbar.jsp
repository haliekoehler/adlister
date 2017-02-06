<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/">ADLISTER</a>
        </div>
        <ul class="nav navbar-nav navbar-right">

            <c:if test="${sessionScope.user == null}">
                <li><a href="register">Register</a></li>
                <li><a href="login">Login</a></li>
            </c:if>

            <c:if test="${sessionScope.user != null}">
                <li><a href="ads/create">Create Ad</a></li>
                <li><a href="../ads">Show All Ads</a></li>
                <li><a href="profile">Profile</a></li>
                <li><a href="logout">Logout</a></li>
            </c:if>

        </ul>
    </div><!-- /.container-fluid -->
</nav>