package validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodValidationTest {

    @Test
    public void testFoodValidation() {
        Message message = FoodValidation.validateFood("cake", 32.50, 20, "Desserts", 12);
        assertTrue(message.getState(), "Food should have passed food validation");

        Message message2 = FoodValidation.validateFood("cake", -1, 20, "Desserts", 12);
        assertFalse(message2.getState(), "Food should have failed food validation");


    }
}