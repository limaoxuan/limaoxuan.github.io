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
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Login</legend>
        <div>
            <span>Username : </span><input type="text" name="username" autocomplete="off" placeholder="username" value="${user.username}"/>
        </div>
        <div>
            <span>Password : </span><input type="password" name="password" autocomplete="off" placeholder="password"/>
        </div>
        <div>
            save 1 month:
            <input type="checkbox" name="checkbox"  <c:if test="${myCookie}">checked="checked"</c:if>/>
        </div>
        <input type="submit" value="login"/>
    </fieldset>
</form>
</body>
</html>