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
import schedule.SubSchedule;
import validation.Message;
import validation.UserValidation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    public static boolean developerMode = false;

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

        String referer = request.getHeader("Referer");
        if (referer != null && referer.endsWith("/Homepage")) {
            System.out.println("To homepage");
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
        new SubSchedule(request);


        UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
        // get parameters
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");
        String action = request.getParameter("action");
        String mode = request.getParameter("mode");
        developerMode = mode != null && mode.equals("on");

        // for debugging
        System.out.println("-----------------------");
        System.out.println("In LoginServlet line 77");
        System.out.println("User Name: " + userName);
        System.out.println("Password: " + password);
        System.out.println("User Type: " + userType);
        System.out.println("Email: " + email);
        System.out.println("Action: " + action);
        System.out.println("Mode: " + mode);
        System.out.println("-----------------------");

        // this is for the login page because email and username are
        // provided as a single field email.
        if (userName == null) {
            userName = email;
        }

        // Set the usertype to empty string if null when user is logging in
        // to prevent null error
        if (userType == null) {
            userType = "Retailer";
        }

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
                request.getRequestDispatcher("signup.jsp").forward(request, response);
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
            if (!developerMode) {
                if (userDB == null) {
                    request.setAttribute("errorMessage", "User does not exist with that username/email/password");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    System.out.println("Successfully found user account in the database.");
                    // create cookies based on user details
                    UserCookies.createSessionCookies(userDB.getUsername(), userDB.getEmail(), userDB.getId(), response);
                }
            }


            userType = userDB.getUserType();
            System.out.println("Usertype: " + userType);
            switch (userType) {
                case "Retailer":
                    System.out.println("To retailer homepage");
                    response.sendRedirect("RetailerServlet");
                    break;
                case "Organization":

                    System.out.println("Logged in as Organization");

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
