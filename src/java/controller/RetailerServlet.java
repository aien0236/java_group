package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import businesslayer.FoodsBusinessLogic;
import model.food.Food;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
        FoodsBusinessLogic authorBusinessLogic = new FoodsBusinessLogic();
        List<Food> foods = null;

        foods = authorBusinessLogic.getAllFoods();

        request.setAttribute("foods", foods);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/retailer/inventory.jsp");
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
        FoodsBusinessLogic foodBusinessLogic = new FoodsBusinessLogic();
        String foodName = request.getParameter("foodName");
        boolean flag = Boolean.parseBoolean(request.getParameter("flag"));
        Food food = new Food();
        food.setFoodName(foodName);
        food.setFlag(flag);
        foodBusinessLogic.addFood(food);
    }

}
