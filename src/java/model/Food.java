/* File: Author.java
 * Author: Stanley Pieda
 * Date: 2015
 * Modified: May/2022 changed Author to Author - kriger
 * Description: Demonstration of DAO Design Pattern
 */
package model;

public class Food {


    private int id;
    private String foodName;
    private String flag;

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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
