package dataaccesslayer;

import businesslayer.FoodsBusinessLogic;
import model.food.Food;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
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
}