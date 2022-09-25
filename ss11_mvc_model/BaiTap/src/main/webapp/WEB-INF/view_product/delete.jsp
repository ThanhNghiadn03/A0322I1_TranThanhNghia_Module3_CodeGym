<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/9/2022
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/products">Back to list product</a>
</p>
<form method="post">
    <h3>Are you sure ?</h3>
    <fieldset>
        <legend>Product infomation</legend>
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
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Delete product">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>