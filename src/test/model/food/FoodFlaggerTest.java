package model.food;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FoodFlaggerTest {
    @Test
    public void testFlaggable() {
        // test to see if it flags if the expiration date is within the week
        Food food = new Food();
        food.setQuantity(50);
        food.setExpiration_date(Timestamp.from(Instant.now()));
        assertTrue(FoodFlagger.isFoodFlaggable(food), "Food should be donated as true");

        // test to see if it doesn't flag if the expiration date with longer than a week (10 days)
        Food food2 = new Food();
        food.setQuantity(5);
        food.setExpiration_date(Timestamp.from(Instant.from(Instant.now().plus(10, ChronoUnit.DAYS))));
        assertFalse(FoodFlagger.isFoodFlaggable(food), "Food should be donated as false");

        // test to see if excess quantity causes it to be donated
        Food food3 = new Food();
        food.setQuantity(50);
        food.setExpiration_date(Timestamp.from(Instant.from(Instant.now().plus(10, ChronoUnit.DAYS))));
        assertTrue(FoodFlagger.isFoodFlaggable(food), "Food should be donated as true");
    }

    @Test
    public void testCheckAndUpdateFlags() {
        // create an array list of foods. The first should be donated as true and second false
        List<Food> foodList = new ArrayList<>();
        // set the quanttiy to 50 and time to now to flag it as true
        Food food1 = new Food();
        food1.setQuantity(50);
        food1.setExpiration_date(Timestamp.from(Instant.now()));

        // set the quantity to 10 (within limit) and 10 days from now so it doesn't expire
        Food food2 = new Food();
        food2.setQuantity(10);
        food2.setExpiration_date(Timestamp.from(Instant.from(Instant.now().plus(10, ChronoUnit.DAYS))));

        foodList.add(food1);
        foodList.add(food2);

        foodList = FoodFlagger.flagAndUpdateList(foodList);
        assertTrue(foodList.get(0).getFlag(), "First food should be donated to true");

        assertFalse(foodList.get(1).getFlag(), "Second food should be donated to false");
    }

}