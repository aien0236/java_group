<%@ page import="dataaccesslayer.User.UserCookies" %>
<%@ page import="java.util.Map" %>
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

%>
<html>
<head>
    <title>Title</title>
    <!-- adding the css thingy -->
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.7.3/dist/full.min.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<%@ include file="../../components/header.jsp" %>
<div class="p-6 mx-auto max-w-4xl shadow border border-slate-200 rounded">

    <div>
        <a href="Homepage" class='link link-primary'>Homepage</a>
    </div>
    <h1 class="text-3xl mb-8">
        Organization
        <%= username%>
    </h1>
    <div class='flex justify-center flex-wrap gap-8'>
        <a href="OrganizationServlet?page=foodClaims">
            <div class='btn btn-primary '>
                <img src="images/kawaii_milk_icon_white_50.png" alt="kawaii bread icon" width="24" height="24"/>
                List all Food from
                retailer
            </div>
        </a>
        <a href="OrganizationServlet?page=organizationFoods">
            <div class='btn btn-secondary '>
                <img src="images/shopping_cart_icon_white_50.png" alt="kawaii bread icon" width="24" height="24"/>
                View your Claimed
                Foods
            </div>
        </a>
        <a href="OrganizationServlet?page=organizationFoodHistory">
            <div class='btn btn-neutral '>
                <img src="images/history_icon_white_50.png" alt="kawaii bread icon" width="24" height="24"/>
                View your
                Claim History
            </div>
        </a>
    </div>
</div>
</div>
</body>
</html>
