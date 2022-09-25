<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/9/2022
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create new product</title>
    <style>
        .message {
            color: purple;
        }
    </style>
</head>
<body>
<div id="top">
    <h1>Create new product</h1>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <p>
        <a href="/products">Back to product list</a>
    </p>
</div>
<form method="post" id="second">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name :</td>
                <td>
                    <input type="text" name="name" id="name">
                </td>
            </tr>
            <tr>
                <td>price : </td>
                <td>
                    <input type="text" name="price" id="price">
                </td>
            </tr>
            <tr>
                <td>Description : </td>
                <td>
                    <input type="text" name="description" id="description">
                </td>
            </tr>
            <tr>
                <td>Manufacturer : </td>
                <td>
                    <input type="text" name="manufac" id="manufac">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="create product">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
