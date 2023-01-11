<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
<%--        <div class="navbar-header">--%>
<%--            <a class="navbar-brand" href="/ads">Games Database</a>--%>
<%--        </div>--%>
        <ul class="nav navbar-nav">
            <li><a href="/vgames">View listings</a></li>
            <c:choose>
                <c:when test="${sessionScope.userLoggedIn}">
                    <li><a href="/ads/vgames">Sell a Game!</a></li>
                </c:when>
            </c:choose>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${sessionScope.userLoggedIn}">
                    <li><a href="/profile">Profile</a></li>
                    <li><a href="/logout">Logout</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="/register">Register</a></li>
                    <li><a href="/login">Login</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
