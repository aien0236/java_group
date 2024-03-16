<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
<head>
    <title>Login Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.7.3/dist/full.min.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<%@ include file="./components/header.jsp" %>
<%--        <div><a href="AuthorsServlet">List Authors</a></div>--%>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    String userName = (String) request.getParameter("userName");
    String email = (String) request.getParameter("email");
    String password = (String) request.getParameter("password");
    String userType = (String) request.getParameter("userType");
    if (userName == null) {
        userName = "";
    }
    if (email == null) {
        email = "";
    }
    if (password == null) {
        password = "";
    }
    if (userType == null) {
        userType = "";
    }

%>
<div class="p-6 mx-auto max-w-4xl border-2 border-gray-400 p-4 rounded-md">
    <FORM ACTION="LoginServlet" METHOD="POST">
        User Name:
        <br>
        <label for="" class='input input-bordered'>

            <INPUT TYPE="text" NAME="userName" value= <%=userName%>><BR>
        </label>
        <br>
        Email:
        <br>
        <label for="" class='input input-bordered'>

            <input type="text" name="email" value= <%=email%>> <br>
        </label>

        <br>
        Password:
        <br>
        <label for="" class='input input-bordered'>

            <INPUT TYPE="password" NAME="password" value= <%=password%>><BR>
        </label>
        <br>
        User Type:
        <br>
        <select name="userType" class='select select-bordered mb-4'>
            <option <%= userType.equals("Retailer") ? "selected" : ""%> value="Retailer">Retailer</option>
            <option <%= userType.equals("Organization") ? "selected" : ""%> value="Organization">Organization</option>
            <option <%= userType.equals("Consumer") ? "selected" : ""%> value="Consumer">Consumer</option>
        </select>
        <BR>
        <!-- Choose to sign up or log in -->
        <input type="SUBMIT" name="action" value="signup" class='btn'>
        <input type="SUBMIT" name="action" value="login" class='btn btn-primary'>
        <br>
        <br>
        <p class='text-red-700'>
            <% if (errorMessage != null) { %>
            <%= errorMessage%>
            <% } %>
        </p>
    </FORM>
</div>
</body>
</html>
