<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/9/2022
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product</title>
    <link rel="stylesheet" type="text/css" href="layout.css">
    <style>
        h1 {
            text-align: center;
            font-size: 50px;
            font-family: cursive;
        }
        #link_create {
            text-decoration: none;
            font-size: 20px;
            font-family: cursive;
        }
        legend {
            margin-bottom: 20px;
            font-size: 20px;
            font-family: cursive;
        }
        #table_full {
            text-align: -webkit-center;
        }
        table {
            width: 100%;
            text-align: center;
            padding: 10px;
            border-collapse: collapse;
            height: 237px;
        }
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<div id="top">
    <h1>Product</h1>
    <p id="link_create">
        <a href="/products?action=create">Create new product</a>
    </p>
    <legend>
        Product list
    </legend>
</div>
<div id="second">
    <div id="table_full">
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
                <th>Manufacturer</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items='${requestScope["products"]}' var="product">
                <tr>
                    <td>
                        <a href="/products?action=view&id=${product.getId()}">${product.getName()}</a>
                    </td>
                    <td>
                            ${product.getPrice()}
                    </td>
                    <td>
                            ${product.getDescription()}
                    </td>
                    <td>
                            ${product.getManuFac()}
                    </td>
                    <td>
                        <a href="/products?action=edit&id=${product.getId()}">Edit</a>
                    </td>
                    <td>
                        <a href="/products?action=delete&id=${product.getId()}">Delete</a>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
