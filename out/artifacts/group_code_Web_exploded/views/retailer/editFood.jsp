<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<%@ page import="model.food.Food" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: matth
  Date: 2024-03-16
  Time: 9:24 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Retailer Food</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.7.3/dist/full.min.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<%@ include file="/components/header.jsp" %>

<%
    Food food = (Food) request.getAttribute("food");
    String foodName = "";
    int id = 0;
    boolean flag = false;
    double price = 0;
    double discount = 0;
    String foodType = "";
    String expirationDate = null;
    int quantity = 0;
    if (food != null) {
        id = food.getId();
        foodName = food.getFoodName();
        flag = food.getFlag();
        price = food.getPrice();
        discount = food.getDiscount();
        foodType = food.getFoodtype();
        quantity = food.getQuantity();
        expirationDate = food.getExpiration_date().toLocalDateTime().toString();
    }

%>
<div class="p-6 mx-auto max-w-4xl">
    <a href="/group_code_Web_exploded/" class='link link-primary'>Homepage</a>
    <h1 class='text-3xl mb-2'>Edit Food</h1>
    <div class='border-2 border-gray-400 p-4 rounded-md bg-base-200'>
        <FORM ACTION="EditFoodServlet" METHOD="POST">

            <input type="text" hidden id="id" name='id' value= <%= id%>>
            <br>
            <label for="foodName">
                Food Name
            </label>
            <br>

            <INPUT id="foodName" class="input input-bordered mt-2 mb-4" TYPE="text" NAME="foodName"
                   value= <%=foodName%>>

            <br>
            <label for="expirationDate">
                Expiration Date
            </label>
            <br>
            <input type="datetime-local" id="expirationDate" class="input input-bordered mt-2 mb-4"
                   name="expirationDate"
                   value=<%= expirationDate%>>
            <br>


            <label>
                Flag
            </label>
            <br>
            <input type="radio" id="true" name="flag" value="true">
            <label for="true">True</label>
            <input type="radio" id="false" name="flag" value="false">
            <label for="false">False</label>
            <br>
            <div class="mb-4"></div>

            <label for="price">
                Price
            </label>
            <br>
            <input type="text" id="price" name="price" class="input input-bordered mt-2 mb-4" value= <%= price%>>
            <br>

            <label for="discount">
                Discount %
            </label>
            <br>
            <select name="discount" id="discount" class="select select-bordered mb-4 mt-2">
                <option value="10">10%</option>
                <option value="20">20%</option>
                <option value="30">30%</option>
                <option value="40">40%</option>
                <option value="50">50%</option>
                <option value="60">60%</option>
                <option value="70">70%</option>
                <option value="80">80%</option>

            </select>
            <br>

            <label for="foodtype">
                Food Type
            </label>
            <br>

            <select class='select select-bordered mb-4 mt-2' name="foodtype" id="foodtype">
                <option value="Fruits & Vegetables">Fruits & Vegetables</option>
                <option value="Dairy & Eggs">Dairy & Eggs</option>
                <option value="Meat & Seafood">Meat & Seafood</option>
                <option value="Grains & Starches">Grains & Starches</option>
                <option value="Other">Other</option>
            </select>
            <br>

            <label for="quantity">
                Quantity
            </label>
            <br>


            <input type="text" id="quantity" name="quantity" class="input input-bordered mt-2 mb-4"
                   value= <%= quantity%>>
            <br>

            <button class="btn btn-primary" type="submit">
                Edit Food
            </button>

        </FORM>
    </div>
</div>
</body>
</html>
