<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/11/2022
  Time: 8:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <jsp:include page="../layout/header.jsp"></jsp:include>
    <title>Employee</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>
<center>
    <h1>Edit employee</h1>
    <h2>
        <a href="/furama?action=listEmployee" style="text-decoration: none">List Employee</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="10">
            <tr hidden>
                <td hidden>id</td>
                <td hidden>
                    <input type="text" name="id" id="id" size="45" value="${employee.idEmployee}" hidden>
                </td>
            </tr>
            <tr>
                <th>Họ và tên : </th>
                <td>
                    <input type="text" name="nameEmployee" id="nameEmployee" size="45" value="${employee.fullName}">
                </td>
            </tr>
            <tr>
                <th>Ngày sinh</th>
                <td><input type="text" name="dob" id="dob" size="45" value="${employee.dateOfBirth}"></td>
            </tr>
            <tr>
                <th>Số chứng minh nhân dân : </th>
                <td><input type="text" name="idenCard" id="idenCard" size="45" value="${employee.identityCardNum}"></td>
            </tr>
            <tr>
                <th>Lương : </th>
                <td>
                    <input type="text" name="salary" id="salary" size="45" value="${employee.salary}">
                </td>
            </tr>
            <tr>
                <th>Số điện thoại : </th>
                <td><input type="text" name="phoneNum" id="phoneNum" size="45" value="${employee.phoneNumber}"></td>
            </tr>
            <tr>
                <th>Email : </th>
                <td><input type="text" name="email" size="45" id="email" value="${employee.mail}"></td>
            </tr>
            <tr>
                <th>Địa chỉ : </th>
                <td><input type="text" name="address" id="address" size="45" value="${employee.address}"></td>
            </tr>
            <tr>
                <th>Vị trí : </th>
                <td>
                    <select name="position" id="position">
                        <c:forEach var="position" items="${positionList}" varStatus="count">
                            <option value="${position.idPosition}">${position.nameOfPosition}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Bộ phận : </th>
                <td>
                    <select name="department" id="department">
                        <c:forEach var="department" items="${departmenList}" varStatus="count">
                            <option value="${department.idDepartment}">${department.nameOfDepartment}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Trình độ : </th>
                <td>
                    <select name="degree" id="degree">
                        <c:forEach var="degree" items="${degreeList}" varStatus="count">
                            <option value="${degree.idEduDegree}">${degree.nameOfEduDegree}</option>
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
