<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/9/2022
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete customer</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <a href="/customers">Back to list customer</a>
</p>
<form method="post">
    <h3>Are you sure ?</h3>
    <fieldset>
        <legend>Customer infomation</legend>
        <table>
            <tr>
                <td>Name : </td>
                <td>${requestScope["customer"].getName()}</td>
            </tr>
            <tr>
                <td>Email : </td>
                <td>${requestScope["customer"].getEmail()}</td>
            </tr>
            <tr>
                <td>Address : </td>
                <td>${requestScope["customer"].getAddress()}</td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Delete customer">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
