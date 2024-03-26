<%--https://stackoverflow.com/questions/4928271/how-to-install-jstl-it-fails-with-the-absolute-uri-cannot-be-resolved-or-una --%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@page import="businesslayer.FoodsBusinessLogic" %>
<%@page import="java.util.List" %>
<%@page import="model.food.Food" %>
<%@ page import="model.food.Food" %>
<%@ page import="model.food.FoodFlagger" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Food> foods = (List<Food>) request.getAttribute("foods");
%>

<html>
<head>
    <title>Organization Inventory</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.7.3/dist/full.min.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<%@ include file="../../components/header.jsp" %>
<div class="mx-auto max-w-4xl">
<div class="overflow-x-auto">
    <table class="table">
        <!-- head -->
        <thead>
        <tr>
            <th></th>
            <th>Name</th>
            <th>Price</th>
            <th>Discount</th>
            <th>Type</th>
            <th>Quantity</th>
            <th>Expiration</th>
            <th>Claim</th>
        </tr>
        </thead>
        <tbody>
        <% for (int i = 0; i < foods.size(); i++) { %>
        <tr class="<%= foods.get(i).getFlag() ? "bg-error" : "" %>">
            <th><%= i + 1%>
            </th>
            <td><%= foods.get(i).getFoodName()%>
            </td>
            <td><%= foods.get(i).getPrice()%>
            </td>
            <td><%= foods.get(i).getDiscount()%> %
            </td>
            <td><%= foods.get(i).getFoodtype()%>
            </td>
            <td><%= foods.get(i).getQuantity()%>
            </td>
            <td><%= foods.get(i).getExpiration_date()%>
            </td>
            <td>
                <a href="ClaimFoodServlet?id=<%=foods.get(i).getId()%>" class="btn btn-primary btn-sm">Claim</a>
            </td>

        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</div>
</body>
</html>
