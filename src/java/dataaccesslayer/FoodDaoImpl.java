/* File: AuthorsDataAccessObjectImplementation.java
 * AuthorDTO: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern with Servlet website
 * References:
 * Ram N. (2013).  Data Access Object Design Pattern or DAO Pattern [blog] Retrieved from
 * http://ramj2ee.blogspot.in/2013/08/data-access-object-design-pattern-or.html
 */
package dataaccesslayer;

import java.util.List;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.food.Food;

public class FoodDaoImpl {

    public FoodDaoImpl() {
    }

    public List<Food> getAllFoods() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Food> foods = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT id, food_name, expiration_date, flag, price, discount, foodtype, quantity, retailer_id " +
                            "FROM retailer_inventory");
            rs = pstmt.executeQuery();
            foods = new ArrayList<Food>();
            while (rs.next()) {
                Food food = new Food();
                food.setId(rs.getInt("id"));
                food.setFoodName(rs.getString("food_name"));
                food.setExpiration_date(rs.getTimestamp("expiration_date"));
                food.setFlag(rs.getBoolean("flag"));
                food.setPrice(rs.getDouble("price"));
                food.setDiscount(rs.getInt("discount"));
                food.setFoodtype(rs.getString("foodtype"));
                food.setQuantity(rs.getInt("quantity"));
                food.setUser_id(rs.getInt("retailer_id"));
                foods.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return foods;
    }

    public List<Food> getFlaggedFoods() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Food> foods = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT id, food_name, expiration_date, flag, flagged, price, discount, foodtype, quantity, retailer_id" +
                            " FROM retailer_inventory WHERE flagged = true");
            rs = pstmt.executeQuery();
            foods = new ArrayList<Food>();
            while (rs.next()) {
                Food food = new Food();
                food.setId(rs.getInt("id"));
                food.setFoodName(rs.getString("food_name"));
                food.setExpiration_date(rs.getTimestamp("expiration_date"));
                food.setFlag(rs.getBoolean("flag"));
                food.setFlagged(rs.getBoolean("flagged"));
                food.setPrice(rs.getDouble("price"));
                food.setDiscount(rs.getInt("discount"));
                food.setFoodtype(rs.getString("foodtype"));
                food.setQuantity(rs.getInt("quantity"));
                food.setUser_id(rs.getInt("retailer_id"));
                foods.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return foods;
    }

    public boolean addFood(Food food) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean updateState = false;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            // do not insert AuthorID, it is generated by Database
            pstmt = con.prepareStatement("INSERT INTO retailer_inventory (food_name, expiration_date, flag, flagged, price, discount, foodtype, quantity, retailer_id) " +
                    "VALUES(?, ?, ?, false, ?, ?, ?, ?, ?)");
            pstmt.setString(1, food.getFoodName());
            pstmt.setTimestamp(2, food.getExpiration_date());
            pstmt.setBoolean(3, food.getFlag());
            pstmt.setDouble(4, food.getPrice());
            pstmt.setInt(5, food.getDiscount());
            pstmt.setString(6, food.getFoodtype());
            pstmt.setInt(7, food.getQuantity());
            pstmt.setInt(8, food.getUser_id());
            // execute insert
            int rowsAffected = pstmt.executeUpdate();

            // true if a row was updated, so the insert was successful
            if (rowsAffected > 0) {
                updateState = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return updateState;
    }

    public Food getFoodById(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        Food food = null;
        ResultSet rs;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            // do not insert AuthorID, it is generated by Database
            pstmt = con.prepareStatement("SELECT id, food_name, expiration_date, flag, flagged, price, discount, foodtype, quantity, retailer_id " +
                    "FROM retailer_inventory WHERE id = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                food = new Food();
                food.setId(rs.getInt("id"));
                food.setFoodName(rs.getString("food_name"));
                food.setExpiration_date(rs.getTimestamp("expiration_date"));
                food.setFlag(rs.getBoolean("flag"));
                food.setFlagged(rs.getBoolean("flagged"));
                food.setPrice(rs.getDouble("price"));
                food.setDiscount(rs.getInt("discount"));
                food.setQuantity(rs.getInt("quantity"));
                food.setFoodtype(rs.getString("foodtype"));
                food.setUser_id(rs.getInt("retailer_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return food;
    }

    public boolean updateFood(Food food) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean updateState = false;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement("UPDATE retailer_inventory SET food_name = ?, expiration_date = ?, flag = ?, flagged = ?, price = ?, discount = ?, foodtype = ?, quantity = ?, retailer_id = ? " +
                    "WHERE id = ?");
            pstmt.setString(1, food.getFoodName());
            pstmt.setTimestamp(2, food.getExpiration_date());
            pstmt.setBoolean(3, food.getFlag());
            pstmt.setBoolean(4, food.isFlagged());
            pstmt.setDouble(5, food.getPrice());
            pstmt.setInt(6, food.getDiscount());
            pstmt.setString(7, food.getFoodtype());
            pstmt.setInt(8, food.getQuantity());
            pstmt.setInt(9, food.getId());
            pstmt.setInt(10, food.getUser_id());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                updateState = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return updateState;
    }

    public boolean donateFood(Food food) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean donateState = false;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement("UPDATE retailer_inventory SET flagged = true " +
                    "WHERE id = ?");
            pstmt.setInt(1, food.getId());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                donateState = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return donateState;
    }

}
