<%@ page import="com.codeup.adlister.models.VGames" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.codeup.adlister.dao.MySQLVGamesDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Games for sale" /> </jsp:include>
</head>

<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Here Are all the ads!</h1>
    <div>
        <form method="POST" action="/search">
            <div class="form-group d-flex">
                <input id="title" name="query" class="form-control mr-1" type="text">&nbsp;
                <input type="submit" class="btn btn-primary" value="Search"> </div>
        </form>
    </div>
    <c:forEach var="game" items="${vgames}">
    <div class="four-column-summary">
        <div class="col-sm-6 col-md-3">
<%--            Using thumbnail for easy border --%>
            <div class="thumbnail"> <img src="../../images/v-o-i-d.jpg" alt="cd case">
            <div class="caption">
                <h3>Title: ${game.title}</h3>
                <ul class="list-group">
                    <li class="list-group-item">Console: ${game.console}</li>
                    <li class="list-group-item">Genre: ${game.genre}</li>
                    <li class="list-group-item">Desc: ${game.description}</li>
                    <li class="list-group-item">Condition: ${game.condition}</li>
                    <li class="list-group-item">Type: ${game.type}</li>
                    <li class="list-group-item">Price: ${game.price}</li>
                </ul>
                    <%-- Buttons at bottom | Edit & Delete --%>
                <div class="btn-group btn-group-justified" role="group" aria-label="...">
                    <div class="btn-group">
                            <form method="POST" action="ads/">
                                <input style="display:none" id="gameID2" name="gameID2" class="form-control mr-1" type="text" value="${game.id}">
                                <input class="btn btn-sm btn-info" type="submit" value="EDIT"> </form>
                    </div>
                    <div class="btn-group">
                        <a></a>
                    </div>
                    <div class="btn-group">
                            <form method="POST" action="ads/delete">
                                <input style="display:none" id="gameID" name="gameID" class="form-control mr-1" type="text" value="${game.id}">
                                <input class="btn btn-sm btn-danger" type="submit" value="DELETE"> </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    </c:forEach>
</body>

</html>