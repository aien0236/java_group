package schedule;

import dataaccesslayer.FoodDaoImpl;
import dataaccesslayer.User.UserCookies;
import dataaccesslayer.subscription.AlertLogDao;
import dataaccesslayer.subscription.SubscriptionDao;
import dataaccesslayer.subscription.impl.AlertLogDaoImpl;
import dataaccesslayer.subscription.impl.SubscriptionDaoImpl;
import model.food.Food;
import model.subscription.AlertLog;
import model.subscription.Subscription;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SubSchedule {

    private SubscriptionDao subscriptionDao = new SubscriptionDaoImpl();

    private AlertLogDao alertLogDao = new AlertLogDaoImpl();

    private FoodDaoImpl foodDao = new FoodDaoImpl();

    private HttpServletRequest request;

    public SubSchedule(HttpServletRequest request) {
        this.request = request;
        new BatchInsertRunner().start();
    }

    //
    private class BatchInsertRunner extends Thread {
        //
        private int retryCount = 0;

        //
        @Override
        public void run() {
            try {
                List<Subscription> list = new ArrayList<>();
                while (true) {
                    List<Subscription> subs = subscriptionDao.findAllById(Integer.valueOf(UserCookies.getUserId(request)));
                    List<Food> allFoods = foodDao.getAllFoods();
                    long threeDaysAgoMillis = System.currentTimeMillis() - (3 * 24 * 60 * 60 * 1000);
                    for (Subscription sub : subs) {
                        for (Food allFood : allFoods) {

                            if (Objects.equals(sub.getFoodPreferenceType(), allFood.getFoodtype())
                                    && allFood.getExpiration_date().getTime() >= threeDaysAgoMillis) {
                                AlertLog alertLog = new AlertLog();
                                alertLog.setContent("expired");
                                alertLog.setEmail(sub.getEmail());
                                alertLog.setUserId(sub.getUserId());
                                alertLog.setStatus("succeed");
                                alertLog.setFoodPreferenceType(allFood.getFoodtype());
                                alertLogDao.add(alertLog);
                            }
                        }
                    }
                    Thread.sleep(86400000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
