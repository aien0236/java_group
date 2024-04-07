<%@ page import="model.food.Food" %>
<%@ page import="java.util.List" %>
<%@ page import="businesslayer.FoodsBusinessLogic" %><%--
  Created by IntelliJ IDEA.
  User: Benson
  Date: 2024-03-14
  Time: 10:25 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% FoodsBusinessLogic foodsBusinessLogic = new FoodsBusinessLogic();
    List<Food> foods = foodsBusinessLogic.organizationGetAllFoodsByUserId(); %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consumer</title>
    <!-- Customized Stylesheets -->
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.7.3/dist/full.min.css" rel="stylesheet" type="text/css"/>
    <!-- Added an external JavaScript file with the 'defer' attribute to enable deferred loading -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<!-- Header -->
<%@ include file="../../components/header.jsp" %>

<!-- Header -->
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
                <th>Purchase</th>
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
                    <a href="BuyFoodServlet?id=<%=foods.get(i).getId()%>" class="btn btn-primary btn-sm"> + </a>
                </td>

            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
