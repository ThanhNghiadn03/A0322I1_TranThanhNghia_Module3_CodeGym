<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/11/2022
  Time: 8:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="../layout/header.jsp"></jsp:include>
    <title>Add new customer</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>
<center>
    <h1>Add new customer</h1>
    <h2>
        <a href="/furama?action=listCustomer" style="text-decoration: none">List All customers</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="10">
            <tr>
                <th>Họ tên</th>
                <td><input type="text" name="nameCustomer" id="nameCustomer" size="45"></td>
            </tr>
            <tr>
                <th>Ngày sinh</th>
                <td><input type="text" name="dob" id="dob" size="45"></td>
            </tr>
            <tr>
                <th>Giới tính</th>
                <td>
                    <select name="gender" id="gender">
                        <option value="true">Nam</option>
                        <option value="false">Nữ</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Số chứng minh nhân dân : </th>
                <td><input type="text" name="idenCard" id="idenCard" size="45"></td>
            </tr>
            <tr>
                <th>Số điện thoại : </th>
                <td><input type="text" name="phoneNum" id="phoneNum" size="45"></td>
            </tr>
            <tr>
                <th>Email : </th>
                <td><input type="text" name="email" size="45" id="email"></td>
            </tr>
            <tr>
                <th>Địa chỉ : </th>
                <td><input type="text" name="address" id="address" size="45"></td>
            </tr>
            <tr>
                <th>Loại khách : </th>
                <td>
                    <select name="customerType" id="customerType">
                        <c:forEach var="cusType" items="${customerTypeList}" varStatus="count">
                            <option value="${cusType.id}">${cusType.nameTypeOfCustomer}</option>
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
