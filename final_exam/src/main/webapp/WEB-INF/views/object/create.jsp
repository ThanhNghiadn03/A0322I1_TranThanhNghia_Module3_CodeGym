<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/12/2022
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="../layouts/header.jsp"></jsp:include>
    <title>Title</title>
</head>
<body>
<jsp:include page="../layouts/navbar.jsp"></jsp:include>
<center>
    <h1>Add new</h1>
    <h2>
        <a href="" >List</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="10">
            <tr>
                <th></th>
                <td>
                    <input type="text" name="" id="" size="45">
                </td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <input type="text" name="" id="." size="45">
                </td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <select name="" id="...">
                        <c:forEach var="" items="${l}" varStatus="count">
                            <option value="${l}">${l}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
