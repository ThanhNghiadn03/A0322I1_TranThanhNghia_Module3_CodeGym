<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/11/2022
  Time: 8:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="../layout/header.jsp"></jsp:include>
    <title>Add new employee</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>
<center>
    <h1>Add new employee</h1>
    <h2>
        <a href="/furama?action=listEmployee" style="text-decoration: none">List All Employee</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="10">
            <tr>
                <th>Họ tên</th>
                <td><input type="text" name="nameEmployee" id="nameEmployee" size="45"></td>
            </tr>
            <tr>
                <th>Ngày sinh</th>
                <td><input type="text" name="dob" id="dob" size="45"></td>
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
                <th>Lương : </th>
                <td>
                    <input type="text" name="salary" id="salary" size="45">
                </td>
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
