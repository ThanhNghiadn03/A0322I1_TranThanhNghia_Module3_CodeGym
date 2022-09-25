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
    <title>Edit customer</title>
</head>
<body>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name : </td>
                <td>
                    <input type="text" name="name" id="name" value="${requestScope["product"].getName()}">
                </td>
            </tr>
            <tr>
                <td>Price : </td>
                <td>
                    <input type="text" name="price" id="price" value="${requestScope["product"].getPrice()}">
                </td>
            </tr>
            <tr>
                <td>Description : </td>
                <td>
                    <input type="text" name="description" id="description" value="${requestScope["product"].getDescription()}">
                </td>
            </tr>
            <tr>
                <td>Manufacturer : </td>
                <td>
                    <input type="text" name="manufac" id="manufac" value="${requestScope["product"].getManuFac()}">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Update product">
                </td>
            </tr>

        </table>
    </fieldset>
</form>
</body>
</html>
