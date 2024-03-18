<%--
  Created by IntelliJ IDEA.
  User: matth
  Date: 2024-03-17
  Time: 9:26 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class='border-2 border-gray-400 p-4 rounded-md'>
    <h2 class="text-2xl">Add Food</h2>
    <FORM ACTION="RetailerServlet" METHOD="POST">

        <input type="text" hidden id="id" name='id'>
        <br>
        <label for="foodName">
            Food Name
        </label>
        <br>

        <INPUT id="foodName" class="input input-bordered mt-2 mb-4" TYPE="text" NAME="foodName"
        >

        <br>
        <label for="expirationDate">
            Expiration Date
        </label>
        <br>
        <input type="datetime-local" id="expirationDate" class="input input-bordered mt-2 mb-4"
               name="expirationDate"
        >
        <br>


        <label>
            Flag
        </label>
        <br>
        <input type="radio" id="true" name="flag" value="true">
        <label for="true">True</label>
        <input type="radio" id="false" name="flag" value="false">
        <label for="false">False</label>
        <br>
        <div class="mb-4"></div>

        <label for="price">
            Price
        </label>
        <br>
        <input type="text" id="price" name="price" class="input input-bordered mt-2 mb-4">
        <br>

        <label for="discount">
            Discount %
        </label>
        <br>
        <select name="discount" id="discount" class="select select-bordered mb-4 mt-2">
            <option value="0">None</option>
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

        <label for="foodtype">
            Food Type
        </label>
        <br>

        <select class='select select-bordered mb-4 mt-2' name="foodtype" id="foodtype">
            <option value="Fruits & Vegetables">Fruits & Vegetables</option>
            <option value="Dairy & Eggs">Dairy & Eggs</option>
            <option value="Meat & Seafood">Meat & Seafood</option>
            <option value="Grains & Starches">Grains & Starches</option>
            <option value="Desserts">Desserts</option>
            <option value="Other">Other</option>
        </select>
        <br>

        <label for="quantity">
            Quantity
        </label>
        <br>


        <input type="text" id="quantity" name="quantity" class="input input-bordered mt-2 mb-4"
        >
        <br>

        <button class="btn btn-primary" type="submit">
            Add Food
        </button>

    </FORM>
</div>
</body>
</html>
