/*
 * File: ForumServlet.java
 * Author: Benson Chang
 * Date: 2024.03.25
 * Description: Implementation of Servlet website
 *
 * References:
 * [1] Unknown. AuthorServlet.java. Algonquin College, Ottawa.
 *     Retrieved from W10 - 2-AuthorsJSP.
 */
package controller.consumer;

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

public class ConsumerServlet extends HttpServlet {

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

        // get a list of donated foods
        FoodsBusinessLogic foodBusinessLogic = new FoodsBusinessLogic();
        List<Food> foods = null;

        System.out.println("In ConsumerServlet");
        String purpose  = request.getParameter("purpose");
        String foodtype  = request.getParameter("foodtype");

        if (purpose != null){
            switch (purpose){
                case "sort-by-food-type":
                    System.out.println(purpose);
                    switch (foodtype){
                        case "fruits":
                            System.out.println(foodtype);
                            foods = foodBusinessLogic.getFoodsByType("Fruits & Vegetables");
                            System.out.println(foods);
                            break;
                        case "dairy":
                            foods = foodBusinessLogic.getFoodsByType("Dairy & Eggs");
                            break;
                        case "meat":
                            foods = foodBusinessLogic.getFoodsByType("Meat & Seafood");
                            break;
                        case "grains":
                            foods = foodBusinessLogic.getFoodsByType("Grains & Starches");
                            break;
                        case "desserts":
                            foods = foodBusinessLogic.getFoodsByType("Desserts");
                            break;
                        case "other":
                            foods = foodBusinessLogic.getFoodsByType("Other");
                            break;
                    }
                    request.setAttribute("foods", foods);
                    request.getRequestDispatcher("views/consumer/home.jsp").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("views/consumer/home.jsp").forward(request, response);
                    break;
            }
        }else {
            request.getRequestDispatcher("views/forum/home.jsp").forward(request, response);
        }
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


}
