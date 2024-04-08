/* File: AuthorsBusinessLogic.java
 * AuthorDTO: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern with Servlet website
 */
package businesslayer;

import dataaccesslayer.FoodDaoImpl;

import java.util.List;

import model.food.Food;
import model.users.User;

public class FoodsBusinessLogic {

    private FoodDaoImpl foodsDao = null;

    public FoodsBusinessLogic() {
        foodsDao = new FoodDaoImpl();
    }

    public List<Food> getAllFoods() {
        return foodsDao.getAllFoods();
    }

    public List<Food> getAllFoodsByUserId(int userId) {
        return foodsDao.getAllFoodsByUserId(userId);
    }
    public List<Food> organizationGetAllFoodsByUserId(int userId) {
        return foodsDao.organizationGetAllFoodsByUserId(userId);
    }
    public List<Food> consumerGetAllFoodsByUserId(int userId) {
        return foodsDao.consumerGetAllFoodsByUserId(userId);
    }    public List<Food> getFoodsByType(String foodtype) {
        return foodsDao.getFoodsByType(foodtype);
    }

    public List<Food> getDonatedFoods() {
        return foodsDao.getDonatedFoods();
    }

    public boolean addFood(Food food) {
        return foodsDao.addFood(food);
    }
    public boolean addFoodForConsumer(Food food) {
        return foodsDao.addFoodForConsumer(food);
    }

    public Food getFoodById(int foodId) {
        return foodsDao.getFoodById(foodId);
    }

    public boolean updateFood(Food food) {
        return foodsDao.updateFood(food);
    }

    public boolean donateFood(Food food) {
        return foodsDao.donateFood(food);
    }

    public boolean claimFoodByOrganization(int userId, int foodId) {
        return foodsDao.claimFoodByOrganization(userId, foodId);
    }

    public boolean claimFoodByConsumer(int userId, int foodId) {
        return foodsDao.claimFoodByOrganization(userId, foodId);
    }


}
