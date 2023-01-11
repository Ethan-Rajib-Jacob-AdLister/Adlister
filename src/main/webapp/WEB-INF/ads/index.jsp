<%@ page import="com.codeup.adlister.models.VGames" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.codeup.adlister.dao.MySQLVGamesDao" %>
<%@ page import="com.codeup.adlister.dao.ListVGamesDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Vgame" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />


<%--<%--%>
<%--int id = Integer.parseInt(request.getParameter("id"));--%>
<%--    VGames singleGame = new VGames(MySQLVGamesDao.con);--%>
<%--    Vgames singleGame2 = singleGame.getSingleGame(id);--%>
<%--    request.setAttribute("edit game", o);--%>


<%--%>--%>





<c:forEach var="game" items="${vgames}">
<div class="four-column-summary">
    <div class="col-sm-6 col-md-3">
        <div class="thumbnail">
            <img src="../../images/v-o-i-d.jpg"> alt="cd case">
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
                <p><a href="#" class="btn btn-primary" role="button">Edit</a> <a href="#" class="btn btn-default" role="button">Delete</a></p>
            </div>
        </div>
    </div>
</div>
</c:forEach>




</body>
</body>
</html>
