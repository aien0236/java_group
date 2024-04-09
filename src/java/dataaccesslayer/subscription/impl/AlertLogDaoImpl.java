package dataaccesslayer.subscription.impl;

import dataaccesslayer.DataSource;
import dataaccesslayer.User.UserCookies;
import dataaccesslayer.subscription.AlertLogDao;
import model.subscription.AlertLog;
import model.subscription.Subscription;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlertLogDaoImpl implements AlertLogDao {
    @Override
    public void add(AlertLog alertLog) {
        String query = "INSERT INTO alert_log (user_id, email, content, food_preference_type) VALUES (?, ?, ?, ?)";
        try (Connection connection = new DataSource().createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, alertLog.getUserId());
            preparedStatement.setString(2, alertLog.getEmail());
            preparedStatement.setString(3, alertLog.getContent());
            preparedStatement.setString(4, alertLog.getFoodPreferenceType());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AlertLog> findAll(HttpServletRequest request) {
        List<AlertLog> logs = new ArrayList<>();
        try (Connection conn = new DataSource().createConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select a.id, a.user_id, a.email, a.content, a.food_preference_type, a.status,u.user_name\n" +
                     "from alert_log a\n" +
                     "left join fwrp.user u on u.id = a.user_id where a.user_id = " + UserCookies.getUserId(request))) {
            System.out.printf("select a.id, a.user_id, a.email, a.content, a.food_preference_type, a.status,u.user_name\n" +
                    "from alert_log a\n" +
                    "left join fwrp.user u on u.id = a.user_id where a,user_id = " + UserCookies.getUserId(request));
            while (rs.next()) {
                AlertLog log = new AlertLog();
                log.setId(rs.getInt("id"));
                log.setUserId(rs.getLong("user_id"));
                log.setUsername(rs.getString("user_name"));
                log.setEmail(rs.getString("email"));
                log.setContent(rs.getString("content"));
                log.setFoodPreferenceType(rs.getString("food_preference_type"));
                logs.add(log);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logs;
    }


}
