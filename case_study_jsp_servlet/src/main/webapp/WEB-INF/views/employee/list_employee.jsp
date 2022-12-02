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
    <title>Employee</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="/furama?action=createEmployee" style="text-decoration: none">Add New Employee</a>
    </h2>
</center>
<div align="center">
    <table class="table">
        <thead>
        <tr>
            <th>Họ tên</th>
            <th>Ngày sinh</th>
            <th>Số chứng minh</th>
            <th>Số điện thoại</th>
            <th>Email</th>
            <th>Địa chỉ</th>
            <th>Lương</th>
            <th>Vị trí</th>
            <th>Trình độ</th>
            <th>Bộ phận</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${listEmployee}" varStatus="count">
            <tr>
                <td><c:out value="${employee.fullName}"></c:out></td>
                <td><c:out value="${employee.dateOfBirth}"></c:out></td>
                <td><c:out value="${employee.identityCardNum}"></c:out></td>
                <td><c:out value="${employee.phoneNumber}"></c:out></td>
                <td><c:out value="${employee.mail}"></c:out></td>
                <td><c:out value="${employee.address}"></c:out></td>
                <td><c:out value="${employee.salary}"></c:out></td>
                <td><c:out value="${employee.position.nameOfPosition}"></c:out></td>
                <td><c:out value="${employee.educationDegree.nameOfEduDegree}"></c:out></td>
                <td><c:out value="${employee.department.nameOfDepartment}"></c:out></td>
                <td>
                    <a href="/furama?action=editEmployee&idEmployee=${employee.idEmployee}" style="text-decoration: none">Edit</a>
                    <a href="/furama?action=deleteEmployee&idEmployee=${employee.idEmployee}" style="text-decoration: none">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</div>

</body>
</html>
