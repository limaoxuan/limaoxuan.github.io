<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 2019-07-10
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<form method="post">
    <div class="container my-container">
        <div class="content">
            <div class="form-group">
                <label for="username">Username :</label>
                <input type="text" class="form-control" id="username" name="username" value="${cookie.username.value}"
                       placeholder="username">
            </div>
            <div>
                <label for="password">Password : </label>
                <input type="password" class="form-control" id="password" name="password" placeholder="password">
            </div>
            <div>
                <div class="form-group form-check">
                    <input type="checkbox" id="exampleCheck1"
                           <c:if test="${cookie.containsKey('username')}">checked="checked"</c:if> name="checkbox"
                           class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1"> save 1 month:</label>
                </div>

            </div>
            <input type="submit" class="btn btn-primary" value="login"/>
            <div>${error}</div>
        </div>


    </div>

</form>
</body>
</html>