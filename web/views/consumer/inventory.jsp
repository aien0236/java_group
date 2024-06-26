<%@page import="businesslayer.FoodsBusinessLogic" %>
<%@page import="java.util.List" %>
<%@page import="model.food.Food" %>
<%@ page import="businesslayer.UserBusinessLogic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Map<String, String> cookieMap = UserCookies.getCookieMap(request);
    String id = cookieMap.get("id");
    System.out.println(id);
    FoodsBusinessLogic foodsBusinessLogic = new FoodsBusinessLogic();
    List<Food> foods = foodsBusinessLogic.consumerGetAllFoodsByUserId(Integer.parseInt(id)); %>
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

</head>
<body>
<%@ include file="../../components/header.jsp" %>

<div class="navdiv">
    <div class="navitem">
        <button>
            <a href="ConsumerServlet?purpose=search" id="search" class="nav-button"><img src="images/iconsearch.png" alt="cart"></a>
        </button>
        <span>Market</span>
    </div>
    <div class="navitem">
        <button>
            <a href="ConsumerServlet?purpose=inventory" id="inventory" class="nav-button"><img src="images/iconinventory.png" alt="cart"></a>
        </button>
        <span>Depot</span>
    </div>
</div>

<div class="mx-auto max-w-4xl">

    <div class="text-sm breadcrumbs mb-8">
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
                <a href="ConsumerServlet">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                         class="w-4 h-4 stroke-current">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                              d="M3 7v10a2 2 0 002 2h14a2 2 0 002-2V9a2 2 0 00-2-2h-6l-2-2H5a2 2 0 00-2 2z"></path>
                    </svg>
                    Consumer
                </a>
            </li>
            <li>
      <span class="inline-flex gap-2 items-center">
        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" class="w-4 h-4 stroke-current"><path
                stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                d="M9 13h6m-3-3v6m5 5H7a2 2 0 01-2-2V5a2 2 0 012-2h5.586a1 1 0 01.707.293l5.414 5.414a1 1 0 01.293.707V19a2 2 0 01-2 2z"></path></svg>
       Inventory
      </span>
            </li>
        </ul>
    </div>
    <div class="overflow-x-auto">
        <table class="table">
            <!-- head -->
            <thead>
            <tr>
                <th></th>
                <th>Name</th>
                <th>Type</th>
                <th>Quantity</th>
                <th>Expiration</th>
            </tr>
            </thead>
            <tbody>
            <% for (int i = 0; i < foods.size(); i++) { %>
            <tr>
                <th><%= i + 1%>
                </th>
                <td><%= foods.get(i).getFoodName()%>
                </td>
                <td><%= foods.get(i).getFoodtype()%>
                </td>
                <td><%= foods.get(i).getQuantity()%>
                </td>
                <td><%= foods.get(i).getExpiration_date()%>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
