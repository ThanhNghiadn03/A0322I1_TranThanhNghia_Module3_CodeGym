<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/9/2022
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert money</title>
</head>
<body>
<form method="post" action="converter.jsp">
    <h2>Currency Converter</h2>
    <label>
        Rate :
    </label>
    <input type="text" name="rate" value="22000">
    <br>
    <label>
        USD :
    </label>
    <input type="text" name="usd" value="0">
    <br>
    <input type="submit" id="submit" value="Converter">
</form>
</body>
</html>
