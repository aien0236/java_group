package dataaccesslayer.subscription.impl;

import dataaccesslayer.DataSource;
import dataaccesslayer.subscription.SubscriptionDao;
import model.subscription.Subscription;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscriptionDaoImpl implements SubscriptionDao {

    private static final String URL = "jdbc:mysql://localhost:3306/database_name";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Override
    public void add(Subscription subscription) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = new DataSource().createConnection();
            String sql = "INSERT INTO subscription (user_id, subscriber_name, email," +
                    " phone, food_preference_type,location) VALUES (?,?,?,?,?,?)";

            stmt = conn.prepareStatement(sql);

            stmt.setLong(1, 1);
            stmt.setString(2, subscription.getSubscriberName());
            stmt.setString(3, subscription.getEmail());
            stmt.setString(4, subscription.getPhone());
            stmt.setString(5, subscription.getFoodPreferenceType());
            stmt.setString(6, subscription.getLocation());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }
    }

    // 关闭连接的方法，可供其他方法调用
    private void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
