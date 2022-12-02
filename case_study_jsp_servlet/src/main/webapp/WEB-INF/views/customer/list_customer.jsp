<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/11/2022
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="../layout/header.jsp"></jsp:include>
    <title>Customer</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/furama?action=createCustomer" style="text-decoration: none">Add New Customer</a>
    </h2>
</center>
<div align="center">
    <table class="table">
        <thead>
        <tr>
            <th>Code</th>
            <th>Họ tên</th>
            <th>Ngày sinh</th>
            <th>Giới tính</th>
            <th>Số chứng minh</th>
            <th>Số điện thoại</th>
            <th>Email</th>
            <th>Địa chỉ</th>
            <th>Loại khách</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${listCustomer}" varStatus="count">
            <tr>
                <td><c:out value="${customer.code}"></c:out></td>
                <td><c:out value="${customer.fullName}"></c:out></td>
                <td><c:out value="${customer.dateOfBirth}"></c:out></td>
                <td>
                    <c:if test="${customer.gender == true}">
                        <c:out value="Nam"></c:out>
                    </c:if>
                    <c:if test="${customer.gender == false}">
                        <c:out value="Nữ"></c:out>
                    </c:if>
                </td>
                <td><c:out value="${customer.identityCardNum}"></c:out></td>
                <td><c:out value="${customer.phoneNumber}"></c:out></td>
                <td><c:out value="${customer.mail}"></c:out></td>
                <td><c:out value="${customer.address}"></c:out></td>
                <td><c:out value="${customer.type.nameTypeOfCustomer}"></c:out></td>
                <td>
                    <a href="/furama?action=editCustomer&idCustomer=${customer.idCustomer}" style="text-decoration: none">Edit</a>
                    <a href="/furama?action=deleteCustomer&idCustomer=${customer.idCustomer}" style="text-decoration: none">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</div>

</body>
</html>
