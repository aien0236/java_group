<%@ page import="dataaccesslayer.User.UserCookies" %>
<%@ page import="java.util.Map" %>
<%@ page import="static controller.LoginServlet.developerMode" %>
<%--
  Created by IntelliJ IDEA.
  User: Benson
  Date: 2024-03-14
  Time: 10:25 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Map<String, String> cookieMap = UserCookies.getCookieMap(request);
    String username = cookieMap.get("username");
    String email = cookieMap.get("email");
    // redirect to login page if not logged in
    if (username == null && !developerMode) {
        request.setAttribute("errorMessage", "You are not logged in");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }


%>
<html>
<head>
    <title>Homepage</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.7.3/dist/full.min.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<%@ include file="../../components/header.jsp" %>

<div class="p-6 mx-auto max-w-4xl">
    <a href="Homepage" class='link link-primary'>Homepage</a>
    <h1 class='text-3xl mb-4'>Retailer</h1>
    <%@ include file="addFood.jsp" %>
    <%@ include file="inventory.jsp" %>
</div>


</body>
</html>
