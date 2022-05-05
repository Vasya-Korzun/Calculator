<%--
  Created by IntelliJ IDEA.
  User: vasya
  Date: 01.05.2022
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="calc" method="post">
    <input type="number" placeholder="Number 1" name="num1">
    <input type="number" placeholder="Number 2" name="num2">
    <input type="text" placeholder="Operation" name="operation">
    <button>Submit</button>
</form>
<h1><p>${requestScope.result }</p></h1>
</body>
</html>
