package controller.organization;

import businesslayer.FoodsBusinessLogic;
import dataaccesslayer.User.UserCookies;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ClaimFoodServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the ID of the food item being claimed from the request parameters
        int foodId = Integer.parseInt(request.getParameter("id"));

        // Get the logged-in user ID from the session
        HttpSession session = request.getSession();
        int loggedInUserId = Integer.parseInt(UserCookies.getCookieMap(request).get("id"));

        // Call a method in the business logic layer to mark the food item as claimed
        FoodsBusinessLogic foodsBusinessLogic = new FoodsBusinessLogic();
        boolean claimed = foodsBusinessLogic.claimFoodByOrganization(loggedInUserId, foodId);

        // Redirect back to the organization inventory page
        if (claimed) {
            System.out.println("Food claimed");
            response.sendRedirect("OrganizationServlet");
        } else {
            // If claiming failed, handle the error (e.g., display an error message)
            // You can forward the request to an error page or display a message on the same page
            request.setAttribute("errorMessage", "Failed to claim food");
            request.getRequestDispatcher("views/organization/home.jsp").forward(request, response);
        }
    }
}
