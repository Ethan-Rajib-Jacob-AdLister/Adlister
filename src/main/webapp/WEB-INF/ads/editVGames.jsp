<%--
Created by IntelliJ IDEA.
User: rajibchaudhary
Date: 1/11/23
Time: 1:09 PM
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Update the Video Game" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Edit Video Game!</h1>
    <form action="/update" method="post">
        <table>
            <th></th>
            <tr><label for="updateTitle">UpdateTitle</label>
                <input id="updateTitle" name="updateTitle" class="form-control" type="text"></tr>
            <th></th>
            <tr><label for="updateCon">UpdateConsole</label>
                <input id="updateCon" name="updateCon" class="form-control" type="text" placeholder="Console Name"></tr>
            <th></th>
            <tr><label for="updateGenre">UpdateGenre</label>
                <input id="updateGenre" name="updateGenre" class="form-control" type="text" placeholder="Genre Name"></tr>
            <th></th>
            <tr><label for="updateType">Update Game Type</label>
                <input id="updateType" name="updateType" class="form-control" type="text" placeholder="CD / Cartridge"></tr>
            <th></th>
            <tr><label for="updateCondition">Condition</label>
                <input id="updateCondition" name="updateCondition" class="form-control" type="text" placeholder="Brand New / Great / Good"></tr>
            <th></th>
            <tr><label for="updatePrice">UpdatePrice</label>
                <input id="updatePrice" name="updatePrice" class="form-control" type="text" placeholder="$0.00"></tr>
            <th></th>
            <tr><label for="updateDescription">UpdateDescription</label>
                <textarea id="updateDescription" name="updateDescription" class="form-control" type="text"></textarea></tr>
            <th></th>
        </table>
        <input type="submit">
    </form>
</div>
</body>
</html>