<%--https://stackoverflow.com/questions/4928271/how-to-install-jstl-it-fails-with-the-absolute-uri-cannot-be-resolved-or-una --%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@page import="businesslayer.FoodsBusinessLogic"%>
<%@page import="java.util.List" %>
<%@page import="model.Food" %>
<%@ page import="model.Food" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<% AuthorsBusinessLogic authorService = new AuthorsBusinessLogic();
    List<Author> foods = authorService.getAllAuthors(); %>
--%>

<html>
    <head>
        <title>Author List</title>
    </head>
    <body>
        <h2>Book List</h2>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Food Name</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <% List<Food> foods = (List<Food>) request.getAttribute("foods");
                for (Food food : foods) {%>
                <tr>
                    <td><%= food.getId()%></td>
                    <td><%= food.getFoodName()%></td>
                    <td></td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>
