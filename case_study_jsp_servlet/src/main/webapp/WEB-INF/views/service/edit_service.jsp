<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21/11/2022
  Time: 6:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="../layout/header.jsp"></jsp:include>
    <title>Service</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>
<center>
    <h1>Edit Service</h1>
    <h2>
        <a href="/furama?action=listService" style="text-decoration: none">List Service</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="10">
            <tr hidden>
                <td hidden>id</td>
                <td hidden>
                    <input type="text" name="id" id="id" size="45" value="${service.idService}" hidden>
                </td>
            </tr>
            <tr>
                <th>Tên dịch vụ : </th>
                <td>
                    <input type="text" name="nameService" id="nameService" size="45" value="${service.nameService}">
                </td>
            </tr>
            <tr>
                <th>Diện tích : </th>
                <td>
                    <input type="text" name="area" id="area" size="45" value="${service.areaService}">
                </td>
            </tr>
            <tr>
                <th>Chi phí : </th>
                <td>
                    <input type="text" name="cost" id="cost" size="45" value="${service.costService}">
                </td>
            </tr>
            <tr>
                <th>Số người tối đa : </th>
                <td>
                    <input type="text" name="maxPeople" id="maxPeople" size="45" value="${service.maxPeople}">
                </td>
            </tr>
            <tr>
                <th>Tiêu chuẩn phòng : </th>
                <td>
                    <input type="text" name="standardRoom" id="standardRoom" size="45" value="${service.roomStandard}">
                </td>
            </tr>
            <tr>
                <th>Mô tả khác : </th>
                <td>
                    <input type="text" name="des" id="des" size="45" value="${service.descriptionOtherConvenience}">
                </td>
            </tr>
            <tr>
                <th>Diện tích hồ bơi: </th>
                <td>
                    <input type="text" name="areaPool" id="areaPool" size="45" value="${service.poolArea}">
                </td>
            </tr>
            <tr>
                <th>Số tầng : </th>
                <td>
                    <input type="text" name="numFloor" id="numFloor" size="45" value="${service.numOfFloors}">
                </td>
            </tr>
            <tr>
                <th>Kiểu thuê : </th>
                <td>
                    <select name="rentType" id="rentType">
                        <c:forEach var="rentType" items="${rentType}" varStatus="count">
                            <option value="${rentType.idRentType}">${rentType.nameRenType}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Loại dịch vụ : </th>
                <td>
                    <select name="serviceType" id="serviceType">
                        <c:forEach var="serviceType" items="${serviceType}" varStatus="count">
                            <option value="${serviceType.idServiceType}">${serviceType.nameServiceType}</option>
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
