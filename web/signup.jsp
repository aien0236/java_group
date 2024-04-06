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
<div class="p-6 mx-auto max-w-4xl shadow-md p-4 rounded-md bg-base-200">
    <h1 class="text-2xl">Signup Page</h1>
    <FORM ACTION="LoginServlet" METHOD="POST">

        <br>
        <label for="username">
            User Name
        </label>
        <br>
        <INPUT id='username' class='input input-bordered mt-2' TYPE="text" NAME="userName" value= <%=userName%>><BR>


        <br>
        <label for="email">
            Email
        </label>
        <br>
        <input id='email' class='input input-bordered mt-2' type="text" name="email" value= <%=email%>> <br>


        <br>
        <label for="password">
            Password
        </label>

        <br>
        <INPUT id='password' class='input input-bordered mt-2' TYPE="password" NAME="password" value= <%=password%>><BR>

        <br>
        User Type
        <br>
        <select name="userType" class='select select-bordered mb-8 mt-2'>
            <option <%= userType.equals("Retailer") ? "selected" : ""%> value="Retailer">Retailer</option>
            <option <%= userType.equals("Organization") ? "selected" : ""%> value="Organization">Organization</option>
            <option <%= userType.equals("Consumer") ? "selected" : ""%> value="Consumer">Consumer</option>
        </select>
        <br>
        <p>Already have an account?
            <a href="index.jsp" class="link link-primary">Log in</a></p>
        <BR>
        <!-- Choose to sign up or log in -->
        <input type="SUBMIT" name="action" value="signup" class='btn btn-primary'>
        <input type="checkbox" id="mode" name="mode">
        <label for="mode">Developer Mode</label>
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
