<%@ page import="model.food.Food" %><%--
  Created by IntelliJ IDEA.
  User: matth
  Date: 2024-03-16
  Time: 11:15 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%
    Food food = (Food) request.getAttribute("food");
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage == null) {
        errorMessage = "";
    }
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

    <div class="text-sm breadcrumbs">
        <ul>
            <li>
                <a href="index.jsp">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                         class="w-4 h-4 stroke-current">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                              d="M3 7v10a2 2 0 002 2h14a2 2 0 002-2V9a2 2 0 00-2-2h-6l-2-2H5a2 2 0 00-2 2z"></path>
                    </svg>
                    Home
                </a>
            </li>
            <li>
                <a href="RetailerServlet">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                         class="w-4 h-4 stroke-current">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                              d="M3 7v10a2 2 0 002 2h14a2 2 0 002-2V9a2 2 0 00-2-2h-6l-2-2H5a2 2 0 00-2 2z"></path>
                    </svg>
                    Retailer
                </a>
            </li>
            <li>
      <span class="inline-flex gap-2 items-center">
        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" class="w-4 h-4 stroke-current"><path
                stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                d="M9 13h6m-3-3v6m5 5H7a2 2 0 01-2-2V5a2 2 0 012-2h5.586a1 1 0 01.707.293l5.414 5.414a1 1 0 01.293.707V19a2 2 0 01-2 2z"></path></svg>
       Donate Food
      </span>
            </li>
        </ul>
    </div>

    <h1 class='text-3xl mb-2'>Donate Food</h1>
    <div class="max-w-md bg-base-200 p-4 divide-y divide-accent-content shadow-md">
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
                <input type="number" id='id' name='id' hidden value= <%= food.getId()%>>

                <button type="submit" class='btn btn-primary'>Donate</button>
            </form>
        </div>
    </div>
    <p class='text-error'><%= errorMessage%>
    </p>
</div>
</body>
</html>
