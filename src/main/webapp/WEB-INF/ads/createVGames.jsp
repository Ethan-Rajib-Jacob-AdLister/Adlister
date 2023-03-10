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
    <h1>Create a new game</h1>
    <form action="/createGames" method="post">
        <table>
            <th></th>
            <tr><label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text"></tr>
            <th></th>
            <tr><label for="con">Console</label>
                <input id="con" name="con" class="form-control" type="text" placeholder="Console Name"></tr>
            <th></th>
            <tr><label for="genre">Genre</label>
                <input id="genre" name="genre" class="form-control" type="text" placeholder="Genre Name"></tr>
            <th></th>
            <tr><label for="type">Game Type</label>
                <input id="type" name="type" class="form-control" type="text" placeholder="CD / Cartridge"></tr>
            <th></th>
            <tr><label for="condition">Condition</label>
                <input id="condition" name="condition" class="form-control" type="text" placeholder="Brand New / Great / Good"></tr>
            <th></th>
            <tr><label for="price">Price</label>
                <input id="price" name="price" class="form-control" type="text" placeholder="$0.00"></tr>
            <th></th>
            <tr><label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea></tr>
            <th></th>
        </table>
        <input type="submit">
    </form>
</div>
</body>
</html>
