package controller.retailer;

import businesslayer.FoodsBusinessLogic;
import model.food.Food;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EditFoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FoodsBusinessLogic foodsBusinessLogic = new FoodsBusinessLogic();
        int foodId = Integer.parseInt(req.getParameter("id"));
        // fetch food from database and update request
        Food food = foodsBusinessLogic.getFoodById(foodId);
        req.setAttribute("food", food);
        // clear cache so it has new data for the food once it's edited
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setDateHeader("Expires", 0);
        // redirect to edit food page
        req.getRequestDispatcher("views/retailer/editFood.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FoodsBusinessLogic foodsBusinessLogic = new FoodsBusinessLogic();

        // get parameters
        String foodName = req.getParameter("foodName");
        String expirationDateString = req.getParameter("expirationDate");
        Timestamp expirationDate = Timestamp.valueOf(LocalDateTime.parse(expirationDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));
        double price = Double.parseDouble(req.getParameter("price"));
        int discount = Integer.parseInt(req.getParameter("discount"));
        String foodtype = req.getParameter("foodtype");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int id = Integer.parseInt(req.getParameter("id"));
        // create the food item
        Food food = new Food();
        food.setFoodName(foodName);
        food.setExpiration_date(expirationDate);
        food.setPrice(price);
        food.setDiscount(discount);
        food.setFoodtype(foodtype);
        food.setQuantity(quantity);
        food.setId(id);
        // update the food
        boolean foodUpdated = foodsBusinessLogic.updateFood(food);
        // food successfully updated
        if (foodUpdated) {
            // get food list and redirect back to retailer home page
            List<Food> foods = foodsBusinessLogic.getAllFoods();
            req.setAttribute("foods", foods);
            req.getRequestDispatcher("views/retailer/home.jsp").forward(req, resp);
            // redirect back to edit food page with an error message
        } else {
            req.setAttribute("errorMessage", "Failed to update food");
            req.setAttribute("food", food);
            req.getRequestDispatcher("views/retailer/editFood.jsp").forward(req, resp);
        }


    }
}
