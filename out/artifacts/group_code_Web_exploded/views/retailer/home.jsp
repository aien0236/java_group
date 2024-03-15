<%--
  Created by IntelliJ IDEA.
  User: Benson
  Date: 2024-03-14
  Time: 10:25 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div><a href="LoginServlet">Homepage</a></div>
    this is the page for retailer
    <FORM ACTION="RetailerServlet" METHOD="POST">
        Food Name:
        <INPUT TYPE="text" NAME="foodName" ><BR>
        Flag:
        <INPUT TYPE="text" NAME="flag"><BR>
        <input type="SUBMIT" name="action" value="Add Food">
    </FORM>
    <div><a href="RetailerServlet">List all Food</a></div>
</body>
</html>
