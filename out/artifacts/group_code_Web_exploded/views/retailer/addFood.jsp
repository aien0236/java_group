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
<div class='border-2 border-gray-400 p-4 rounded-md bg-base-200 inline-block'>
    <h2 class="text-2xl">Add Food</h2>
    <FORM ACTION="RetailerServlet" METHOD="POST">

        <table>

            <tr>
                <input type="text" hidden id="id" name='id'>
                <br>

                <td class='pr-8'>
                    <label for="foodName">
                        Food Name
                    </label>
                    <br>

                    <INPUT id="foodName" class="input input-bordered mt-2 mb-4" TYPE="text" NAME="foodName"
                    >
                </td>

                <td>

                    <label for="expirationDate">
                        Expiration Date
                    </label>
                    <br>
                    <input type="datetime-local" id="expirationDate" class="input input-bordered mt-2 mb-4"
                           name="expirationDate"
                    >
                </td>
            </tr>
            <br>

            <tr>
                <td class="pr-8">
                    <label for="price">
                        Price
                    </label>
                    <br>
                    <input type="text" id="price" name="price" class="input input-bordered mt-2 mb-4">
                </td>

                <td>
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
                </td>
            </tr>

            <tr>
                <td>
                    <label for="quantity">
                        Quantity
                    </label>
                    <br>

                    <input type="text" id="quantity" name="quantity" class="input input-bordered mt-2 mb-4"
                    >
                </td>
            </tr>
        </table>
        <button class="btn btn-primary" type="submit">
            Add Food
            <img src="images/plus_icon_white_24.png" width="20" height="20"/>
        </button>

    </FORM>
</div>
</body>
</html>
