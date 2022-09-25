<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/9/2022
  Time: 8:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="/customers?action=create">Create new customer</a>
</p>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items='${requestScope["customers"]}' var="customer" >
        <tr>
            <td>
                <a href="/customers?action=view&id=${customer.getId()}">${customer.getName()}</a>
            </td>
            <td>
                ${customer.getEmail()}
            </td>
            <td>
                ${customer.getAddress()}
            </td>
            <td>
                <a href="/customers?action=edit&id=${customer.getId()}">edit</a>
            </td>
            <td>
                <a href="/customers?action=delete&id=${customer.getId()}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
