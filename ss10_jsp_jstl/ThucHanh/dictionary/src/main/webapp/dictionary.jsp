<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/9/2022
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<%!
    Map<String , String> dic = new HashMap<>();
%>
<%
    dic.put("Book","sách");
    dic.put("Computer","máy tính");

    String search = request.getParameter("search");
    PrintWriter writer = response.getWriter();
    String result = dic.get(search);
    if (result != null) {
        writer.println("Word : "+search);
        writer.println("Result : "+result);
    } else {
        writer.println("Not found");
    }
%>
</body>
</html>
