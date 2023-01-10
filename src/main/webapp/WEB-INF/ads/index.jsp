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

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c:forEach var="game" items="${vgames}">
        <div class="col-md-6">
            <h2>Title: ${game.title}</h2>
            <p>Console: ${game.console}</p>
            <p>Genre: ${game.genre}</p>
            <p>Desc: ${game.description}</p>
            <p>Condition: ${game.condition}</p>
            <p>Type: ${game.type}</p>
            <p>Price: ${game.price}</p>
        </div>
    </c:forEach>
</div>


</body>
</html>
