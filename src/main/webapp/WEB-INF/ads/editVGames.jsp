<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit a Video Game" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Edit a game</h1>
    <form action="/ads/editCommit" method="post">
        <table>
            <th></th>
            <tr><label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text" value=${editGame.title}></tr>
            <th></th>
            <tr><label for="con">Console</label>
                <input id="con" name="con" class="form-control" type="text" placeholder="Console Name" value=${editGame.console}></tr>
            <th></th>
            <tr><label for="genre">Genre</label>
                <input id="genre" name="genre" class="form-control" type="text" placeholder="Genre Name" value=${editGame.genre}></tr>
            <th></th>
            <tr><label for="type">Game Type</label>
                <input id="type" name="type" class="form-control" type="text" placeholder="CD / Cartridge" value=${editGame.type}></tr>
            <th></th>
            <tr><label for="condition">Condition</label>
                <input id="condition" name="condition" class="form-control" type="text" placeholder="Brand New / Great / Good" value=${editGame.condition}></tr>
            <th></th>
            <tr><label for="price">Price</label>
                <input id="price" name="price" class="form-control" type="text" placeholder="$0.00" value=${editGame.price}></tr>
            <th></th>
            <tr><label for="desc">Description</label>
                <textarea id="desc" name="desc" class="form-control" type="text" value=${editGame.description}></textarea></tr>
            <tr><input style="display:none" type="text" name="gameID" id="gameID" value=${editGame.id}></tr>
            <th></th>
        </table>
        <input type="submit">
    </form>
</div>
</body>
</html>
