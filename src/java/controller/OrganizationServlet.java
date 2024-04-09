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

public class OrganizationServlet extends HttpServlet {

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

        foods = foodBusinessLogic.getDonatedFoods();
        System.out.println(foods);

        // set the donated foods to the request
        request.setAttribute("foods", foods);

        // page in url get req. Ex. OrganizationServlet?page=foodClaims
        String pageRequest = request.getParameter("page");

        // make sure pageRequest isn't null to avoid error (meaning query param not sent in url)
        if (pageRequest != null) {

            // redirect to foodClaims page based on url parameter
            if (pageRequest.equals("foodClaims")) {
                request.getRequestDispatcher("views/organization/availableFoods.jsp").forward(request, response);
            }
            // redirect to foodClaims page based on url parameter
            else if (pageRequest.equals("organizationFoods")) {
                request.getRequestDispatcher("views/organization/claimedFoods.jsp").forward(request, response);
            }
            // redirect to foodClaims page based on url parameter
            else if (pageRequest.equals("organizationFoodHistory")) {
                request.getRequestDispatcher("views/organization/history.jsp").forward(request, response);
            }
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("views/organization/home.jsp");
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
