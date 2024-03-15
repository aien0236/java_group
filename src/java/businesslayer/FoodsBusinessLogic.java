/* File: AuthorsBusinessLogic.java
 * AuthorDTO: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern with Servlet website
 */
package businesslayer;

import dataaccesslayer.FoodDaoImpl;
import java.util.List;
import java.sql.SQLException;
import model.Food;

public class FoodsBusinessLogic {

    private FoodDaoImpl foodsDao = null;

    public FoodsBusinessLogic() {
        foodsDao = new FoodDaoImpl();
    }

    public List<Food> getAllFoods() throws SQLException {
        return foodsDao.getAllFoods();
    }
    public List<Food> getFoodsWithFlag(String flag) throws SQLException {
        return foodsDao.getFoodsWithFlag(flag);
    }

    public void addFood(Food food) {
        foodsDao.addFood(food);
    }
}
