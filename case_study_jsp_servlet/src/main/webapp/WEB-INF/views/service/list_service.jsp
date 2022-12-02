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
    <title>Service</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>
<center>
    <h1>Service Management</h1>
    <h2>
        <a href="/furama?action=createService" style="text-decoration: none">Add New Service</a>
    </h2>
</center>
<div align="center">
    <table class="table">
        <thead>
        <tr>
            <th>Tên dịch vụ</th>
            <th>Diện tích</th>
            <th>Giá dịch vụ</th>
            <th>Số người tối đa</th>
            <th>Tiêu chuẩn phòng</th>
            <th>Mô tả khác</th>
            <th>Diện tích hồ bơi</th>
            <th>Số tầng</th>
            <th>Loại thuê</th>
            <th>Loại dịch vụ</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="service" items="${listService}" varStatus="count">
            <tr>
                <td><c:out value="${service.nameService}"></c:out></td>
                <td><c:out value="${service.areaService}"></c:out></td>
                <td><c:out value="${service.costService}"></c:out></td>
                <td><c:out value="${service.maxPeople}"></c:out></td>
                <td><c:out value="${service.roomStandard}"></c:out></td>
                <td><c:out value="${service.descriptionOtherConvenience}"></c:out></td>
                <td><c:out value="${service.poolArea}"></c:out></td>
                <td><c:out value="${service.numOfFloors}"></c:out></td>
                <td><c:out value="${service.rentType.nameRenType}"></c:out></td>
                <td><c:out value="${service.serviceType.nameServiceType}"></c:out></td>
                <td>
                    <a href="/furama?action=editService&idService=${service.idService}" style="text-decoration: none">Edit</a>
                    <a href="/furama?action=deleteService&idService=${service.idService}" style="text-decoration: none">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</div>

</body>
</html>
