package controller.retailer;

import businesslayer.FoodsBusinessLogic;
import model.food.Food;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DonateFoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FoodsBusinessLogic foodsBusinessLogic = new FoodsBusinessLogic();
        int foodId = Integer.parseInt(req.getParameter("id"));
        // get food from database based on url provided id and update request
        Food food = foodsBusinessLogic.getFoodById(foodId);
        req.setAttribute("food", food);
        req.getRequestDispatcher("views/retailer/donateFood.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FoodsBusinessLogic foodsBusinessLogic = new FoodsBusinessLogic();
        int foodId = Integer.parseInt(req.getParameter("id"));
        // get food from database based on provided id
        Food food = foodsBusinessLogic.getFoodById(foodId);
        // donate the food (set flagged to true in database for the food)
        boolean successfullyDonated = foodsBusinessLogic.donateFood(food);

        // redirect back to homepage if donation successful
        if (successfullyDonated) {
            resp.sendRedirect("/RetailerServlet");
        } else {
            // go back to donation page and send error message if donation failed
            req.setAttribute("errorMessage", "Failed to donate food");
            req.setAttribute("food", food);
            req.getRequestDispatcher("views/retailer/donateFood.jsp").forward(req, resp);
        }

    }
}
