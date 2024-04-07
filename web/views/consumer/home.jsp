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
<%
    FoodsBusinessLogic foodsBusinessLogic = new FoodsBusinessLogic();
    List<Food> foods = (List<Food>) request.getAttribute("foods");
    if (foods == null){
        foods = foodsBusinessLogic.getAllFoods();
    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consumer</title>
    <!-- Customized Stylesheets -->
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.7.3/dist/full.min.css" rel="stylesheet" type="text/css"/>
    <!-- Added an external JavaScript file with the 'defer' attribute to enable deferred loading -->
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        /* CSS styles will go here */
        #food-icons {
            display: flex;
            justify-content: center;
            text-align: center;
        }

        .food-button {
            background: none;
            border: none;
            cursor: pointer;
            margin-bottom: 8px;
        }

        .food-button img {
            width: 50px; /* You can adjust the size as needed */
            height: auto;
        }

        .food-typ {
            margin: 30px 30px;
        }
    </style>
</head>
<body>
<!-- Header -->
<%@ include file="../../components/header.jsp" %>

<div id="food-icons">
    <div class="food-typ">
        <button id="all" class="food-button"><img src="images/iconall.png" alt="fruits"></button><br>
        <span>Fruits & Vegetables</span>
    </div>
    <div class="food-typ">
        <button id="fruits" class="food-button"><img src="images/iconfruite.png" alt="fruits"></button><br>
        <span>Fruits & Vegetables</span>
    </div>
    <div class="food-typ">
        <button id="dairy" class="food-button"><img src="images/icondaily.png" alt="dairy"></button><br>
        <span>Dairy & Eggs</span>
    </div >
    <div class="food-typ">
        <button id="meat" class="food-button"><img src="images/iconmeat.png" alt="meat"></button><br>
        <span>Meat & Seafood</span>
    </div>
    <div class="food-typ">
        <button id="grains" class="food-button"><img src="images/icongrains.png" alt="grains"></button><br>
        <span>Grains & Starches</span>
    </div>
    <div class="food-typ">
        <button id="desserts" class="food-button"><img src="images/icondessert.png" alt="desserts"></button><br>
        <span>Desserts</span>
    </div>
    <div class="food-typ">
        <button id="other" class="food-button"><img src="images/iconother.png" alt="other"></button><br>
        <span>Other</span>
    </div>
</div>

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

<script>
    // JavaScript will go here
    document.addEventListener('DOMContentLoaded', function () {
        var buttons = document.querySelectorAll('.food-button');
        buttons.forEach(function (button) {
            button.addEventListener('click', function () {
                // You can replace the alert with the actual functionality you need
                window.location.href = 'ConsumerServlet?purpose=sort-by-food-type&foodtype=' + button.id;
            });
        });
    });
</script>

</body>
</html>
