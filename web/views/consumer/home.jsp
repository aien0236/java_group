<%@ page import="model.food.Food" %>
<%@ page import="java.util.List" %>
<%@ page import="businesslayer.FoodsBusinessLogic" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.lang.reflect.Array" %><%--
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
    List<Food> cart = new ArrayList<>();
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css">
    <link rel="stylesheet" type="text/css" href="views/consumer/css/consumer.css">
    <!-- Added an external JavaScript file with the 'defer' attribute to enable deferred loading -->
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="views/consumer/scripts/consumer.js" defer></script>

</head>
<body>
<!-- Header -->
<%@ include file="../../components/header.jsp" %>

<div class="navdiv">
    <div class="navitem">
        <a href="ConsumerServlet?purpose=search" id="search" class="nav-button"><img src="images/iconsearch.png" alt="cart"></a><br>
    </div>

    <div class="navitem">
        <a href="ConsumerServlet?purpose=inventory" id="inventory" class="nav-button"><img src="images/iconhome.png" alt="cart"></a><br>
    </div>

    <div class="navitem">
        <button id="cart" class="nav-button"><img src="images/shopping-cart.png" alt="cart"></button><br>
    </div>
</div>


<div class="container">
    <div class="contentbar">
        <!-- Start row -->
        <div class="row">
            <!-- Start col -->
            <div class="col-md-12 col-lg-12 col-xl-12">
                <div class="card m-b-30">
                    <div class="card-body">
                        <div class="row justify-content-center">
                            <div class="col-lg-10 col-xl-8">
                                <div class="cart-container">
                                    <div class="cart-head">
                                        <div class="table-responsive">
                                            <table class="table table-borderless">
                                                <thead>
                                                <tr>
                                                    <th scope="col">#</th>
                                                    <th scope="col">Name</th>
                                                    <th scope="col">Qty</th>
                                                    <th scope="col">Price</th>
                                                    <th scope="col">Discount</th>
                                                    <th scope="col" class="text-right">Total</th>
                                                    <th scope="col">Action</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="cart-body">
                                        <div class="row">
                                            <div class="col-md-12 order-1 order-lg-2 col-lg-7 col-xl-6">
                                                <div class="order-total table-responsive ">
                                                    <table class="table table-borderless text-right">
                                                        <tbody>
                                                        <tr>
                                                            <td>Sub Total :</td>
                                                            <td id="subTotal">$0.00</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Shipping :</td>
                                                            <td id="shipping">$0.00</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Tax (13%): </td>
                                                            <td id="tax">$0.00</td>
                                                        </tr>
                                                        <tr>
                                                            <td class="f-w-7 font-18"><h4>Amount :</h4></td>
                                                            <td class="f-w-7 font-18"><h4 id="totalAmount">$0.00</h4></td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="cart-footer text-right">
                                        <a id="checkout-btn" class="btn btn-success my-1">Proceed to Checkout<i class="ri-arrow-right-line ml-2"></i></a>
                                        <form id="checkoutForm" action="ConsumerServlet" method="post" style="display:none;"></form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End col -->
        </div>
        <!-- End row -->
    </div>
</div>

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
                <form class="foodForm">
                <input type="hidden" name="id" value="<%= foods.get(i).getId() %>" />
                <th><input type="hidden" name="number" value="<%= i + 1 %>" /><%= i + 1 %></th>
                <td><input type="hidden" name="foodName" value="<%= foods.get(i).getFoodName() %>" /><%= foods.get(i).getFoodName()%></td>
                <td><input type="hidden" name="price" value="<%= foods.get(i).getPrice() %>" /><%= foods.get(i).getPrice()%></td>
                <td><input type="hidden" name="discount" value="<%= foods.get(i).getDiscount() %>" /><%= foods.get(i).getDiscount()%> %</td>
                <td><input type="hidden" name="foodType" value="<%= foods.get(i).getFoodtype() %>" /><%= foods.get(i).getFoodtype()%></td>
                <td><input type="hidden" name="quantity" value="<%= foods.get(i).getQuantity() %>" /><%= foods.get(i).getQuantity()%></td>
                <td><input type="hidden" name="expirationDate" value="<%= foods.get(i).getExpiration_date() %>" /><%= foods.get(i).getExpiration_date()%></td>
                <td><button type="submit" class="btn btn-primary btn-sm addToCartBtn" value="<%= i %>"> + </button></td>
                </form>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
