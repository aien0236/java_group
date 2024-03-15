<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
<%--        <div><a href="AuthorsServlet">List Authors</a></div>--%>

        <FORM ACTION="LoginServlet" METHOD="POST">
            User Name:
            <INPUT TYPE="text" NAME="userName" ><BR>
            Password:
            <INPUT TYPE="password" NAME="password" ><BR>
            User Type:
            <select name="userType">
                <option value="Retailer">Retailer</option>
                <option value="Organization">Organization</option>
                <option value="Consumer">Consumer</option>
            </select><BR>
            <!-- Choose to sign up or log in -->
            <input type="SUBMIT" name="action" value="signup">
            <input type="SUBMIT" name="action" value="login">
        </FORM>
    </body>
</html>
