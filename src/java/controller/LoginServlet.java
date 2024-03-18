package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import businesslayer.FoodsBusinessLogic;
import businesslayer.UserBusinessLogic;
import dataaccesslayer.User.UserCookies;
import model.food.Food;
import model.users.User;
import model.users.UserFactory;
import validation.Message;
import validation.UserValidation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

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
        //
        String referer = request.getHeader("Referer");
        //
        System.out.println("Referer: " + referer);
        //
        if (referer != null && referer.endsWith("/LoginServlet")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {

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
        UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
        // get parameters
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");
        String action = request.getParameter("action");

        // for debugging
        System.out.println("User Name: " + userName);
        System.out.println("Password: " + password);
        System.out.println("User Type: " + userType);
        System.out.println("Email: " + email);
        System.out.println("Action: " + action);

        // create local user object
        User user = UserFactory.createUser(userName, email, password, userType);
        FoodsBusinessLogic foodsBusinessLogic = new FoodsBusinessLogic();
        if ("signup".equals(action)) {
            // create local user, then add it to database

            Message userValidationMessage = UserValidation.validateUser(user);

            // user is invalid
            if (!userValidationMessage.getState()) {
                // set the error message to be output on index.jsp page
                request.setAttribute("errorMessage", userValidationMessage.getValue());
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

            boolean userCreated = userBusinessLogic.createUser(user);
            user = userBusinessLogic.getUser(user);
            // check to see if user was successfully created in database
            if (userCreated) {
                // update user cookies
                UserCookies.createSessionCookies(user.getUsername(), user.getEmail(), user.getId(), response);
                // redirect to user page based on user type
                switch (userType) {
                    case "Retailer":
                        List<Food> foods = new ArrayList<Food>();
                        request.setAttribute("foods", foods);
                        request.getRequestDispatcher("views/retailer/home.jsp").forward(request, response);
                        break;
                    case "Organization":
                        request.getRequestDispatcher("views/organization/home.jsp").forward(request, response);
                        break;
                    case "Consumer":
                        request.getRequestDispatcher("views/consumer/home.jsp").forward(request, response);
                        break;
                    default:
                        break;
                }
            } else {
                request.setAttribute("errorMessage", "Database failed to create user");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else if ("login".equals(action)) {
            // DON'T forget to reference userDB, rather than user
            User userDB = userBusinessLogic.getUser(user);
            // User does not exist in database, redirect back to login with error message
            if (userDB == null) {
                request.setAttribute("errorMessage", "User does not exist with that username/email/password");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else {
                System.out.println("Successfully found user account in the database.");
            }

            // create cookies based on user details
            UserCookies.createSessionCookies(userDB.getUsername(), userDB.getEmail(), userDB.getId(), response);
            switch (userType) {
                case "Retailer":
                    List<Food> foods = null;
                    foods = foodsBusinessLogic.getAllFoods();
                    // Send foods to retailer home page
                    request.setAttribute("foods", foods);
                    request.getRequestDispatcher("views/retailer/home.jsp").forward(request, response);
                    break;
                case "Organization":
                    request.getRequestDispatcher("views/organization/home.jsp").forward(request, response);
                    break;
                case "Consumer":
                    request.getRequestDispatcher("views/consumer/home.jsp").forward(request, response);
                    break;
                default:
                    break;
            }

        }

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
