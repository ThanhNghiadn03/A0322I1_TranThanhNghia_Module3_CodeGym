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
    <title>Customer</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>
<center>
    <h1>Edit customer</h1>
    <h2>
        <a href="/furama?action=listCustomer" style="text-decoration: none">List Customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="10">
            <tr hidden>
                <td hidden>id</td>
                <td hidden>
                    <input type="text" name="id" id="id" size="45" value="${customer.idCustomer}" hidden>
                </td>
            </tr>
            <tr>
                <th>Họ và tên : </th>
                <td>
                    <input type="text" name="nameCustomer" id="nameCustomer" size="45" value="${customer.fullName}">
                </td>
            </tr>
            <tr>
                <th>Ngày sinh</th>
                <td><input type="text" name="dob" id="dob" size="45" value="${customer.dateOfBirth}"></td>
            </tr>
            <tr>
                <th>Giới tính</th>
                <td>
                    <select name="gender" id="gender">
                        <c:if test="${customer.gender == false}">
                            <option value="false">Nữ</option>
                            <option value="true">Nam</option>
                        </c:if>
                        <c:if test="${customer.gender == true}">
                            <option value="true">Nam</option>
                            <option value="false">Nữ</option>
                        </c:if>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Số chứng minh nhân dân : </th>
                <td><input type="text" name="idenCard" id="idenCard" size="45" value="${customer.identityCardNum}"></td>
            </tr>
            <tr>
                <th>Số điện thoại : </th>
                <td><input type="text" name="phoneNum" id="phoneNum" size="45" value="${customer.phoneNumber}"></td>
            </tr>
            <tr>
                <th>Email : </th>
                <td><input type="text" name="email" size="45" id="email" value="${customer.mail}"></td>
            </tr>
            <tr>
                <th>Địa chỉ : </th>
                <td><input type="text" name="address" id="address" size="45" value="${customer.address}"></td>
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
