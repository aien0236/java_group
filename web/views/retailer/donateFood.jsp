<%@ page import="model.food.Food" %><%--
  Created by IntelliJ IDEA.
  User: matth
  Date: 2024-03-16
  Time: 11:15 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%
    Food food = (Food) request.getAttribute("food");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Donate Food</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.7.3/dist/full.min.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<%@ include file="/components/header.jsp" %>
<div class="p-6 mx-auto max-w-4xl">


    <h1 class='text-3xl mb-2'>Donate Food</h1>
    <div class="max-w-md bg-base-200 p-4 divide-y divide-accent-content">
        <div class='pb-2'>


            <table>
                <thead>
                <tr>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>

                <tr>
                    <td>
                        <h2 class='text-xl '> Name:
                        </h2>
                    </td>
                    <td>
                        <h2 class="font-bold text-xl"><%=food.getFoodName()%>
                        </h2>
                    </td>
                </tr>

                <tr>
                    <td>
                        <p>Expiration Date: </p>
                    </td>
                    <td>
                        <p
                                class="font-bold"><%= food.getExpiration_date().toLocalDateTime().toString()%>
                        </p>
                    </td>
                </tr>

                <tr>
                    <td>
                        <p> Flagged: </p>
                    </td>
                    <td>
                        <p class="font-bold"><%= food.getFlag()%>
                        </p>
                    </td>
                </tr>

                <tr>
                    <td>
                        <p> Price: $</p>
                    </td>
                    <td>
                        <p class="font-bold"><%= food.getPrice()%>
                        </p>
                    </td>
                </tr>

                <tr>
                    <td>
                        <p> Discount: %</p>
                    </td>
                    <td>
                        <p class="font-bold"><%= food.getDiscount()%>
                        </p>
                    </td>
                </tr>

                <tr>
                    <td>
                        <p> Food Type: </p>
                    </td>
                    <td>
                        <p class="font-bold"><%= food.getFoodtype()%>
                        </p>
                    </td>
                </tr>

                <tr>
                    <td><p> Quantity (x):</p></td>
                    <td><p class="font-bold"><%= food.getQuantity()%>
                    </p></td>
                </tr>


                </tbody>
            </table>
        </div>
        <div class='pt-2'>
            <h2 class='text-2xl font-bold mb-4'>
                Would you like to donate this food?
            </h2>


            <form action="DonateFoodServlet" method="POST">
                <label for="quantity">
                    Donation amount
                </label>
                <br>
                <input class="mb-4" type="number" id="quantity" name="quantity" min="0"
                       max=<%= food.getQuantity()%> value
                = <%= food.getQuantity()%>>
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
                <button type="submit" class='btn btn-primary'>Donate</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
