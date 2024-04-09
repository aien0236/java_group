package dataaccesslayer.subscription;


import model.subscription.Subscription;

import java.util.List;

public interface SubscriptionDao {

    void add(Subscription subscription);

    void update(Subscription subscription);

    void delete(long id);

    List<Subscription> findAllById(int userId);

    List<Subscription> findPending();

    Subscription findById(long id);

}
