package dataaccesslayer.subscription;

import model.subscription.AlertLog;
import model.subscription.Subscription;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AlertLogDao {

    void add(AlertLog alert);

    List<AlertLog> findAll(HttpServletRequest request);


}
