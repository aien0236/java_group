/* File: AuthorsBusinessLogic.java
 * AuthorDTO: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern with Servlet website
 */
package businesslayer;

import dataaccesslayer.FoodDaoImpl;

import java.util.List;

import model.food.Food;

public class FoodsBusinessLogic {

    private FoodDaoImpl foodsDao = null;

    public FoodsBusinessLogic() {
        foodsDao = new FoodDaoImpl();
    }

    public List<Food> getAllFoods() {
        return foodsDao.getAllFoods();
    }

    public List<Food> getFoodsWithFlag(String flag) {
        return foodsDao.getFoodsWithFlag(flag);
    }

    public void addFood(Food food) {
        foodsDao.addFood(food);
    }

    public Food getFoodById(int foodId) {
        return foodsDao.getFoodById(foodId);
    }

    public boolean updateFood(Food food) {
        return foodsDao.updateFood(food);
    }
}
