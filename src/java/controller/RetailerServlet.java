package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import businesslayer.FoodsBusinessLogic;
import dataaccesslayer.User.UserCookies;
import model.food.Food;
import validation.FoodValidation;
import validation.Message;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class RetailerServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FoodsBusinessLogic foodsBusinessLogic = new FoodsBusinessLogic();
        List<Food> foods = null;
        int userId = Integer.parseInt(UserCookies.getCookieMap(request).get("id"));
        foods = foodsBusinessLogic.getAllFoodsByUserId(userId);

        request.setAttribute("foods", foods);
        System.out.println("in: " + this.getClass());
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/retailer/home.jsp");
        dispatcher.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in: " + this.getClass().toString());
        addFood(request, response);

        doGet(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void addFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> cookieMap = UserCookies.getCookieMap(request);
        // get user id from cookies
        int userId = Integer.parseInt(cookieMap.get("id"));
        FoodsBusinessLogic foodBusinessLogic = new FoodsBusinessLogic();
        String foodName = "";
        Timestamp expirationDate = null;
        // set to -1 to avoid null values and for as an error value
        double price = -1;
        int discount = -1;
        String foodtype = "";
        int quantity = -1;
        try {
            // get food parameters
            foodName = request.getParameter("foodName");
            String expirationDateString = request.getParameter("expirationDate");
            expirationDate = Timestamp.valueOf(LocalDateTime.parse(expirationDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));
            foodtype = request.getParameter("foodtype");
            price = Double.parseDouble(request.getParameter("price"));
            quantity = Integer.parseInt(request.getParameter("quantity"));
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Invalid data.sql input: " + e.getMessage());
            doGet(request, response);
        }

        // validate the food
        Message foodValidationMessage = FoodValidation.validateFood(foodName, price, discount, foodtype, quantity);
        // check if validation state and redirect back to retailer if false
        if (!foodValidationMessage.getState()) {
            request.setAttribute("errorMessage", foodValidationMessage.getValue());
            request.getRequestDispatcher("RetailerServlet").forward(request, response);
        }

        // create the food item
        Food food = new Food();
        food.setFoodName(foodName);
        food.setExpiration_date(expirationDate);
        food.setPrice(price);
        food.setDiscount(discount);
        food.setFoodtype(foodtype);
        food.setQuantity(quantity);
        food.setUser_id(userId);

        // insert the food into the database
        boolean foodInserted = foodBusinessLogic.addFood(food);


        List<Food> foods = foodBusinessLogic.getAllFoodsByUserId(userId);
        request.setAttribute("foods", foods);
        request.getRequestDispatcher("views/retailer/home.jsp").forward(request, response);
    }

}
