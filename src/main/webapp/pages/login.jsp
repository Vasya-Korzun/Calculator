<%@ page contentType="text/html; charset=UTF-16" pageEncoding="UTF-16" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<!DOCTYPE html>
<html>
<head>
    <title>Authentication</title>
</head>
<body>
    <div class="content">
        <form method="post" action="login">
            Login:
            <br/>
            <input class="input" type="text" name="userName" value="${userName}" placeholder="Enter your login">
            <br/>
            <br/>
            Password:
            <br/>
            <input class="input" type="text" name="password" value="${password}" placeholder="Enter your password">

            <br/>
            <input id="submit" type="submit" value="Log in">
        </form>

        <c:if test="${not empty errorMessage}">
            ${errorMessage}
        </c:if>

        <a href="reg">Зарегистрироваться</a>
    </div>
</body>
</html>