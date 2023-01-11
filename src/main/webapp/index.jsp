<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container centered"><h1>Welcome to the Video Game DB!</h1>
        <p class="centered">This is an ad-lister project utilizing JSP and MYSQL to host the trade or sale of home use Video Game cartridges.</p>
        <img src="images/arcade.jpg" class="centered" width="800px" height="600px" alt="arcade">
    </div>
</body>
</html>
