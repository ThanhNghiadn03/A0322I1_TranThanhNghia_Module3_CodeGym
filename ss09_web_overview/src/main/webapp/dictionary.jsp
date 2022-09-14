<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/9/2022
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form method="post" action="/dictionary">
    <h2>Vietnamese Dictionary</h2>
    <br>
    <input type="text" name="word" placeholder="Enter your word">
    <input type="submit" value="search" name="search_word">
</form>
</body>
</html>
