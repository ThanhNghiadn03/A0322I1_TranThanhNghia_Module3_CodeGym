<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/9/2022
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form method="post" action="/calculator">
<h1>Simple Calculator</h1>
    <table>
        <tr>
            <td>
                <label>
                    First operand :
                </label>
            </td>
            <td>
                <input type="text" name="firstOperand">
            </td>
        </tr>
        <tr>
            <td>
                <label>
                    Operator :
                </label>
            </td>
            <td>
                <select name="operand">
                    <option value="+">Addition</option>
                    <option value="-">Subtraction</option>
                    <option value="*">Multiplication</option>
                    <option value="/">Division</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <label>
                    Second operand :
                </label>
            </td>
            <td>
                <input type="text" name="secondOperand">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="Calculate" value="Calculate">
            </td>
        </tr>
    </table>

</form>
</body>
</html>
