<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/12/2022
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="../layouts/header.jsp"></jsp:include>
    <title>Title</title>
</head>
<body>
<jsp:include page="../layouts/navbar.jsp"></jsp:include>
<center>
    <h1></h1>
    <h2>
        <a href="">Add new</a>
    </h2>
</center>
<div align="center">
    <table class="table">
        <thead>
        <tr>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="" items="" varStatus="count">
            <tr>
                <td><c:out value=""></c:out></td>
                <td><c:out value=""></c:out></td>
                <td><c:out value=""></c:out></td>
                <td><c:out value=""></c:out></td>
                <td><c:out value=""></c:out></td>
                <td><c:out value=""></c:out></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</div>
</body>
</html>
