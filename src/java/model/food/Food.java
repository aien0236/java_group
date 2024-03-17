/* File: Author.java
 * Author: Stanley Pieda
 * Date: 2015
 * Modified: May/2022 changed Author to Author - kriger
 * Description: Demonstration of DAO Design Pattern
 */
package model.food;

import java.sql.Timestamp;

public class Food {


    private int id;
    private String foodName;
    private Timestamp expiration_date;
    private boolean flag;
    private double price;
    private int discount;
    private String foodtype;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;

    public Timestamp getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Timestamp expiration_date) {
        this.expiration_date = expiration_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * Return string representation of food.
     * Can be used for testing purposes.
     *
     * @return
     */
    public String toString() {
        return "Food: [ " + foodName + ", " + expiration_date + ", " + flag + ", " + price + ", " + discount + ", " + foodName + " ]";
    }
}
