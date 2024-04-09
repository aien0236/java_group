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
    <h1 class="text-2xl">Login Page</h1>
    <FORM ACTION="LoginServlet" METHOD="POST">

        <br>

        <br>
        <label for="email">
            Email or username
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
        <p>Don't have an account? <a class="link link-primary" href="signup.jsp">Sign up</a></p>
        <BR>
        <!-- Choose to sign up or log in -->
        <input type="SUBMIT" name="action" value="login" class='btn btn-primary'>
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
