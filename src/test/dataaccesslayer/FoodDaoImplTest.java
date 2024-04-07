package dataaccesslayer;

import businesslayer.FoodsBusinessLogic;
import businesslayer.UserBusinessLogic;
import model.food.Food;
import model.users.Organization;
import model.users.User;
import model.users.UserFactory;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FoodDaoImplTest {

    @Test
    public void testAddFood() {
        FoodsBusinessLogic foodsBusinessLogic = new FoodsBusinessLogic();
        Food food = new Food();
        food.setFoodName("tomato");
        food.setExpiration_date(new Timestamp(System.currentTimeMillis()));
        food.setFlag(true);
        food.setPrice(10.5);
        food.setQuantity(10);
        food.setDiscount(10);
        food.setFoodtype("fruit");
        foodsBusinessLogic.addFood(food);
    }

    @Test
    public void testGetAllFoods() {
        List<Food> foods = null;
        FoodsBusinessLogic foodsBusinessLogic = new FoodsBusinessLogic();
        foods = foodsBusinessLogic.getAllFoods();


        assertNotNull(foods, "Food list shouldn't be null");
        System.out.println("Printing all foods...");
        for (Food food : foods) {
            System.out.println(food.toString());
        }
    }

    /**
     * Tests to see if the FoodDaoImpl.getAllFoodsByUserId() works
     * You must have a user with at least 1 food in the database to test this
     */
    @Test
    public void testGetAllFoodsByUserId() {
        FoodsBusinessLogic foodsBusinessLogic = new FoodsBusinessLogic();
        UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
        // replace this with an organization user that is in the database
        String username = "matt123",
                email = "matt@gmail.com",
                password = "matt123",
                usertype = "Retailer";
        User user = UserFactory.createUser(username, email, password, usertype);

        // fetch user from the database
        User userDB = userBusinessLogic.getUser(user);

        List<Food> foods = foodsBusinessLogic.getAllFoodsByUserId(userDB.getId());
        assertNotNull(foods, "Food list shouldn't be null");
        Food food = foods.getFirst();
        assertNotNull(food, "First food shouldn't be null");
        System.out.println(food.toString());

    }

    @Test
    public void testGetFoodById() {
        // change this to an actual food id in the database that you want to retrieve
        int food_id = 5;
        FoodsBusinessLogic foodsBusinessLogic = new FoodsBusinessLogic();
        Food food = foodsBusinessLogic.getFoodById(5);
        assertNotNull(food, "Fetched food shouldn't be null");
        System.out.println("Printing food...");
        System.out.println(food.toString());
    }

    @Test
    public void testClaimFoodByOrganization() {
        FoodsBusinessLogic foodsBusinessLogic = new FoodsBusinessLogic();
        UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
        // replace this with an organization user that is in the database
        String username = "yoyoyo",
                email = "yo@gmail.com",
                password = "yoyoyo",
                usertype = "Organization";
        User user = UserFactory.createUser(username, email, password, usertype);

        // fetch user from the database
        User userDB = userBusinessLogic.getUser(user);

        // fetch all foods to get the first food
        List<Food> foods = foodsBusinessLogic.getAllFoods();
        Food food = foods.getFirst();
        System.out.println(food.toString());

        if (food == null) {
            System.out.println("No foods in database");
        }

        boolean foodClaimed = foodsBusinessLogic.claimFoodByOrganization(userDB.getId(), food.getId());
        assertTrue(foodClaimed, "Claim food state should be true");

    }
}