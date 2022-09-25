<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/9/2022
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<div id="top">
    <h1>Product detail</h1>
    <p>
        <a href="/products">Back to list product</a>
    </p>
</div>
<fieldset>
    <legend>Product detail</legend>
    <table>
        <tr>
            <td>Name : </td>
            <td>${requestScope["product"].getName()}</td>
        </tr>
        <tr>
            <td>Price : </td>
            <td>${requestScope["product"].getPrice()}</td>
        </tr>
        <tr>
            <td>Description : </td>
            <td>${requestScope["product"].getDescription()}</td>
        </tr>
        <tr>
            <td>Manufacturer : </td>
            <td>${requestScope["product"].getManuFac()}</td>
        </tr>
    </table>
</fieldset>
</body>
</html>
