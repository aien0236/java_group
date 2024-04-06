package businesslayer;

import dataaccesslayer.FoodDaoImpl;
import dataaccesslayer.subscription.impl.SubscriptionDaoImp;
import model.food.Food;
import model.subscription.Subscription;

import java.util.List;

public class SubscriptionBusinessLogic {
    private SubscriptionDaoImpl subscrDao = null;

    public SubscriptionBusinessLogic() {
        subscrDao = new SubscriptionDaoImpl();
    }

    public boolean addSubscription(Subscription Subscription) {
        return subscrDao.addSubscription(Subscription);
    }
//check the subscription by search id.
//    public Subscription getSubscriptionById(int subscriptionId) {
//        return subscrDao.getSubscriptionById(foodId);
//    }

    public boolean updateSubFood(Subscription Subscription) {

        return subscrDao.updateSubFood(food);
    }

    public boolean deleteSubscription(Subscription Subscription) {

        return subscrDao.deleteSubFood(food);
    }
}
