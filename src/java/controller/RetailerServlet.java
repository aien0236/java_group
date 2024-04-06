package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import businesslayer.FoodsBusinessLogic;
import dataaccesslayer.User.UserCookies;
import model.food.Food;

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

        foods = foodsBusinessLogic.getAllFoods();

        request.setAttribute("foods", foods);
        System.out.println("in: " + this.getClass().toString());
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

        // get food parameters
        String foodName = request.getParameter("foodName");
        String expirationDateString = request.getParameter("expirationDate");
        Timestamp expirationDate = Timestamp.valueOf(LocalDateTime.parse(expirationDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));
        boolean flag = Boolean.parseBoolean(request.getParameter("flag"));
        double price = Double.parseDouble(request.getParameter("price"));
        int discount = Integer.parseInt(request.getParameter("discount"));
        String foodtype = request.getParameter("foodtype");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // create the food item
        Food food = new Food();
        food.setFoodName(foodName);
        food.setExpiration_date(expirationDate);
        food.setFlag(flag);
        food.setPrice(price);
        food.setDiscount(discount);
        food.setFoodtype(foodtype);
        food.setQuantity(quantity);
        food.setUser_id(userId);
        
        // insert the food into the database
        boolean foodUpdated = foodBusinessLogic.addFood(food);
        if (foodUpdated) {
            request.setAttribute("errorMessage", "Failed to insert food into database");
        }

        List<Food> foods = foodBusinessLogic.getAllFoods();
        request.setAttribute("foods", foods);
        request.getRequestDispatcher("views/retailer/home.jsp").forward(request, response);
    }

}
