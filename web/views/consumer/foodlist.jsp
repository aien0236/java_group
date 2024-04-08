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
    List<Food> foods = foodsBusinessLogic.getAllFoods(); %>

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
            justify-content: space-between;
        }

        .food-button {
            background: none;
            border: none;
            cursor: pointer;
        }

        .food-button img {
            width: 50px; /* You can adjust the size as needed */
            height: auto;
        }
    </style>
</head>
<body>
<!-- Header -->
<%@ include file="../../components/header.jsp" %>

<div id="food-icons">
    <button id="grocery" class="food-button"><img src="path-to-grocery-icon.png" alt="Grocery"></button>
    <button id="pizza" class="food-button"><img src="path-to-pizza-icon.png" alt="Pizza"></button>
    <!-- Add the rest of the buttons similar to the above two -->
</div>
<script>
    // JavaScript will go here
    document.addEventListener('DOMContentLoaded', function () {
        var buttons = document.querySelectorAll('.food-button');
        buttons.forEach(function (button) {
            button.addEventListener('click', function () {
                alert('You clicked on ' + button.id);
                // You can replace the alert with the actual functionality you need
                window.location.href = 'ConsumerServlet?purpose=sort-by-food-type&foodtype=' + button.id;
            });
        });
    });
</script>
</body>
</html>
