<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/9/2022
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer</title>
</head>
<body>
<div>
    <h1>Danh sách khách hàng</h1>
</div>
<table border="1">
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${list}" varStatus="status">
        <tr>
            <td>${customer.getName()}</td>
            <td>${customer.getBirthDate()}</td>
            <td>${customer.getAddress()}</td>
            <td>${customer.getUrlImage()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
