package model.food;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class FoodFlagger {
    public static final int EXPIRATION_DAYS = 7;
    public static final int SURPLUS_LIMIT = 30;

    /**
     * Returns true or false based on if the food is flaggable based
     * on expiration of 7 days and food quantity above 30
     *
     * @param food
     * @return
     */
    public static boolean isFoodFlaggable(Food food) {
        Timestamp weekFromNow = Timestamp.from(Instant.now().plus(7, ChronoUnit.DAYS));
        Timestamp foodTime = food.getExpiration_date();
        boolean isFlagged = false;
        // check if food quantity is above limit
        if (food.getQuantity() > SURPLUS_LIMIT) {
            isFlagged = true;
        }

        // check if the food is within the expiration date
        if (foodTime.before(weekFromNow)) {
            isFlagged = true;
        }
        return isFlagged;
    }

    /**
     * Iterates over provided List<Food> and checks if each food is flaggable
     * If it is flaggable, sets the food to flag = true and updates the list.
     * Returns the list at the end
     *
     * @param foods
     * @return
     */
    public static List<Food> flagAndUpdateList(List<Food> foods) {
        // iterate over food list
        for (int i = 0; i < foods.size(); i++) {
            // get food
            Food food = foods.get(i);
            // check if flaggable
            if (isFoodFlaggable(food)) {
                // update the food flag
                food.setFlag(true);
            } else {
                food.setFlag(false);
            }
            foods.set(i, food);
        }
        // return the updated food list
        return foods;
    }
}
