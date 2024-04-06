<%@page import="java.util.List" %>
<%@page import="model.food.Food" %>
<%@ page import="model.food.FoodFlagger" %>

<%
    List<Food> foods = (List<Food>) request.getAttribute("foods");
    System.out.println("foodz");
    for (Food food : foods) {
        System.out.println(food.toString());
    }
    foods = FoodFlagger.flagAndUpdateList(foods);


%>
<h2 class='text-3xl mb-2 mt-6'>Foods in stock</h2>


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
            <th>Flag</th>
            <th>Donate</th>
            <th>Edit</th>
        </tr>
        </thead>

        <tbody>
        <% for (int i = 0; i < foods.size(); i++) { %>
        <tr class="<%= foods.get(i).getFlag() ? "bg-red-300" : "" %>">
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
            <td><%= foods.get(i).getFlag()%>
            </td>
            <td>
                <a href="DonateFoodServlet?id=<%=foods.get(i).getId()%>" class="btn btn-primary btn-sm">
                    Donate
                </a>
            </td>
            <td>
                <a href="EditFoodServlet?id=<%=foods.get(i).getId()%>" class="btn btn-neutral btn-sm">Edit</a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>

</div>

