package dataaccesslayer.subscription.impl;

import dataaccesslayer.DataSource;
import dataaccesslayer.subscription.SubscriptionDao;
import model.subscription.Subscription;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionDaoImpl implements SubscriptionDao {

    @Override
    public void add(Subscription subscription) {

        try (Connection conn = new DataSource().createConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO subscription (user_id, subscriber_name, email, phone, food_preference_type,location) VALUES (?,?,?,?,?,?)")) {

            stmt.setLong(1, subscription.getUserId());
            stmt.setString(2, subscription.getSubscriberName());
            stmt.setString(3, subscription.getEmail());
            stmt.setString(4, subscription.getPhone());
            stmt.setString(5, subscription.getFoodPreferenceType());
            stmt.setString(6, subscription.getLocation());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Subscription subscription) {
        try (Connection conn = new DataSource().createConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE subscription SET subscriber_name=?, email=?, phone=?, food_preference_type=?, location=? WHERE id=?")) {

            stmt.setString(1, subscription.getSubscriberName());
            stmt.setString(2, subscription.getEmail());
            stmt.setString(3, subscription.getPhone());
            stmt.setString(4, subscription.getFoodPreferenceType());
            stmt.setString(5, subscription.getLocation());
            stmt.setLong(6, subscription.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        try (Connection conn = new DataSource().createConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM subscription WHERE id=?")) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Subscription> findAll() {
        List<Subscription> subscriptions = new ArrayList<>();
        try (Connection conn = new DataSource().createConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM subscription")) {

            while (rs.next()) {
                Subscription subscription = new Subscription();
                subscription.setId(rs.getLong("id"));
                subscription.setUserId(rs.getLong("user_id"));
                subscription.setSubscriberName(rs.getString("subscriber_name"));
                subscription.setEmail(rs.getString("email"));
                subscription.setPhone(rs.getString("phone"));
                subscription.setFoodPreferenceType(rs.getString("food_preference_type"));
                subscription.setLocation(rs.getString("location"));
                subscriptions.add(subscription);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscriptions;
    }

    @Override
    public Subscription findById(long id) {
        Subscription subscription = null;
        try (Connection conn = new DataSource().createConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM subscription WHERE id=?")) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                subscription = new Subscription();
                subscription.setId(rs.getLong("id"));
                subscription.setUserId(rs.getLong("user_id"));
                subscription.setSubscriberName(rs.getString("subscriber_name"));
                subscription.setEmail(rs.getString("email"));
                subscription.setPhone(rs.getString("phone"));
                subscription.setFoodPreferenceType(rs.getString("food_preference_type"));
                subscription.setLocation(rs.getString("location"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscription;
    }

}
