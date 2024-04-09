package businesslayer;

import dataaccesslayer.subscription.impl.SubscriptionDaoImpl;
import model.subscription.Subscription;

import java.util.List;

public class SubscriptionBusinessLogic {
    private SubscriptionDaoImpl dao;

    public SubscriptionBusinessLogic() {
        dao = new SubscriptionDaoImpl();
    }

    public void addSubscription(Subscription Subscription) {
        dao.add(Subscription);
    }

//    public List<Subscription> getAllSubscription() {
//        return dao.findAll();
//    }

    public Subscription getSubscriptionById(int subscriptionId) {
        return dao.findById(subscriptionId);
    }

    public void updateSubFood(Subscription subscription) {
        dao.update(subscription);
    }

    public void deleteSubscription(Integer id) {
        dao.delete(id);
    }

}
