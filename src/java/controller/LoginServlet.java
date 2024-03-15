package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get parameters
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");
        String action = request.getParameter("action");

        // for debug
        System.out.println("User Name: " + userName);
        System.out.println("Password: " + password);
        System.out.println("User Type: " + userType);
        System.out.println("Action: " + action);

        //
        if ("signup".equals(action)) {

        } else if ("login".equals(action)) {
            switch (userType){
                case "Retailer":
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
