package validation;

import java.sql.Timestamp;

public class FoodValidation extends Validation {


    /**
     * Returns a message indicating if the food values are valid
     *
     * @param foodName the name of the food
     * @param price    the price of the food
     * @param discount the discount percent of the food
     * @param foodtype the type of food category
     * @param quantity the quantity of food
     * @return
     */
    public static Message validateFood(String foodName, double price, int discount, String foodtype, int quantity) {
        Message message = new Message("", true);


        // validate the foodName
        Message validationMessage = Validation.stringNotEmpty(foodName, "foodName");

        if (!validationMessage.getState()) {
            message.setState(false);
            message.setValue(message.getValue() + validationMessage.getValue());
        }

        // validate the price
        validationMessage = Validation.numNotEmpty((int) price, "price");

        if (!validationMessage.getState()) {
            message.setState(false);
            message.setValue(message.getValue() + validationMessage.getValue());
        }

        // validate the discount
        validationMessage = Validation.numNotEmpty(discount, "discount");

        if (!validationMessage.getState()) {
            message.setState(false);
            message.setValue(message.getValue() + validationMessage.getValue());
        }


        // validate the foodtype
        validationMessage = Validation.stringNotEmpty(foodtype, "foodtype");

        if (!validationMessage.getState()) {
            message.setState(false);
            message.setValue(message.getValue() + validationMessage.getValue());
        }

        // validate the quantity
        validationMessage = Validation.numNotEmpty(quantity, "quantity");

        if (!validationMessage.getState()) {
            message.setState(false);
            message.setValue(message.getValue() + validationMessage.getValue());
        }

        return message;
    }


}
