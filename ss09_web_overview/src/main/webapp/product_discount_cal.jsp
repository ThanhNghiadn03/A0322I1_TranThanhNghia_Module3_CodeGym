<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/9/2022
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="calDis_pr.css">
</head>
<body>
<form method="post" action="/display-discount">
    <h2>
        Product Discount Calculator
    </h2>
    <label id="pdes">Product description :</label>
    <input type="text" name="desc" placeholder="Enter product description">
    <br>
    <label id="lPrice">
        List price :
    </label>
    <input type="text" name="listPrice" placeholder="Enter list price">
    <br>
    <label id="dPercent">
        Discount percent :
    </label>
    <input type="text" name="discountPercent"
           placeholder="Enter disPercent">
    <br>
    <input type="submit" value="Calculate Discount" id="subCalDis">
</form>
</body>
</html>
