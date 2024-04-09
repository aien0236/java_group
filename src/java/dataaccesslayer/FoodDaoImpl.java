/* File: AuthorsDataAccessObjectImplementation.java
 * AuthorDTO: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern with Servlet website
 * References:
 * Ram N. (2013).  Data Access Object Design Pattern or DAO Pattern [blog] Retrieved from
 * http://ramj2ee.blogspot.in/2013/08/data-access-object-design-pattern-or.html
 */
package dataaccesslayer;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.List;

import java.util.ArrayList;

import model.food.Food;
import model.users.User;

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
                    "SELECT id, food_name, expiration_date, price, discount, foodtype, quantity, retailer_id " +
                            "FROM retailer_inventory WHERE donated = false and claimed = false");
            rs = pstmt.executeQuery();
            foods = new ArrayList<Food>();
            while (rs.next()) {
                Food food = new Food();
                food.setId(rs.getInt("id"));
                food.setFoodName(rs.getString("food_name"));
                food.setExpiration_date(rs.getTimestamp("expiration_date"));
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

    public List<Food> getAllFoodsByUserId(int userId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Food> foods = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT id, food_name, expiration_date, price, discount, foodtype, quantity, retailer_id " +
                            "FROM retailer_inventory WHERE donated = false AND retailer_id = ?");
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            foods = new ArrayList<Food>();
            while (rs.next()) {
                Food food = new Food();
                food.setId(rs.getInt("id"));
                food.setFoodName(rs.getString("food_name"));
                food.setExpiration_date(rs.getTimestamp("expiration_date"));
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


    public List<Food> organizationGetAllFoodsByUserId(int userId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Food> foods = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT *" +
                            "FROM organization_inventory WHERE organization_id = ?");

            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            foods = new ArrayList<Food>();
            while (rs.next()) {
                Food food = new Food();
                food.setId(rs.getInt("org_inv_id"));
                food.setFoodName(rs.getString("food_name"));
                food.setExpiration_date(rs.getTimestamp("expiration_date"));
                food.setFoodtype(rs.getString("foodtype"));
                food.setQuantity(rs.getInt("quantity"));
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

    public List<Food> consumerGetAllFoodsByUserId(int userId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Food> foods = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT *" +
                            "FROM consumers_inventory WHERE consumer_id = ?");

            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            foods = new ArrayList<Food>();
            while (rs.next()) {
                Food food = new Food();
                food.setId(rs.getInt("inventory_id"));
                food.setFoodName(rs.getString("food_name"));
                food.setExpiration_date(rs.getTimestamp("expiration_date"));
                food.setFoodtype(rs.getString("foodtype"));
                food.setQuantity(rs.getInt("quantity"));
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

    public List<Food> getFoodsByType(String foodtype) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Food> foods = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT *" +
                            "FROM retailer_inventory WHERE foodtype = ?");

            pstmt.setString(1, foodtype);
            rs = pstmt.executeQuery();
            foods = new ArrayList<Food>();
            while (rs.next()) {
                Food food = new Food();
                food.setId(rs.getInt("id"));
                food.setFoodName(rs.getString("food_name"));
                food.setExpiration_date(rs.getTimestamp("expiration_date"));
                food.setFoodtype(rs.getString("foodtype"));
                food.setQuantity(rs.getInt("quantity"));
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

    public List<Food> getAllAvailableFoods() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Food> foods = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT id, food_name, expiration_date, price, discount, foodtype, quantity, retailer_id " +
                            "FROM retailer_inventory WHERE donated = false AND claimed_by IS NULL");
            rs = pstmt.executeQuery();
            foods = new ArrayList<>();
            while (rs.next()) {
                Food food = new Food();
                food.setId(rs.getInt("id"));
                food.setFoodName(rs.getString("food_name"));
                food.setExpiration_date(rs.getTimestamp("expiration_date"));
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
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return foods;
    }

    public boolean claimFoodByOrganization(int userId, int foodId) {
        Connection con = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        ArrayList<Food> foods = null;
        String query = "{ call claimFoodByOrganization(?, ?, ?)}";


        boolean state = false;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();

            // prepare the statement
            callableStatement = con.prepareCall(query);
            callableStatement.setInt(1, foodId);
            callableStatement.setInt(2, userId);
            callableStatement.registerOutParameter(3, Types.BOOLEAN);

            // execute the stored procedure
            callableStatement.execute();

            // Get the result if the procedure succeeded
            state = callableStatement.getBoolean(3);

            // output message based on procedure result state
            if (state) {
                System.out.println("claimFoodByOrganization procedure executed successfully");
            } else {
                System.out.println("claimFoodByOrganization procedure failed to execute");
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
                if (callableStatement != null) {
                    callableStatement.close();
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
        return state;

    }


    public boolean claimFoodByConsumer(int userId, int foodId) {
        Connection con = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        ArrayList<Food> foods = null;
        String query = "{ call claimFoodByConsumer(?, ?, ?)}";


        boolean state = false;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();

            // prepare the statement
            callableStatement = con.prepareCall(query);
            callableStatement.setInt(1, foodId);
            callableStatement.setInt(2, userId);
            callableStatement.registerOutParameter(3, Types.BOOLEAN);

            // execute the stored procedure
            callableStatement.execute();

            // Get the result if the procedure succeeded
            state = callableStatement.getBoolean(3);

            // output message based on procedure result state
            if (state) {
                System.out.println("claimFoodByConsumer procedure executed successfully");
            } else {
                System.out.println("claimFoodByConsumer procedure failed to execute");
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
                if (callableStatement != null) {
                    callableStatement.close();
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
        return state;

    }

    public List<Food> getDonatedFoods() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Food> foods = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT id, food_name, expiration_date, donated, price, discount, foodtype, quantity, retailer_id" +
                            " FROM retailer_inventory WHERE donated = true");
            rs = pstmt.executeQuery();
            foods = new ArrayList<Food>();
            while (rs.next()) {
                Food food = new Food();
                food.setId(rs.getInt("id"));
                food.setFoodName(rs.getString("food_name"));
                food.setExpiration_date(rs.getTimestamp("expiration_date"));
                food.setDonated(rs.getBoolean("donated"));
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
            pstmt = con.prepareStatement("INSERT INTO retailer_inventory (food_name, expiration_date, donated, price, discount, foodtype, quantity, retailer_id) " +
                    "VALUES(?, ?, false, ?, ?, ?, ?, ?)");
            pstmt.setString(1, food.getFoodName());
            pstmt.setTimestamp(2, food.getExpiration_date());
            pstmt.setDouble(3, food.getPrice());
            pstmt.setInt(4, food.getDiscount());
            pstmt.setString(5, food.getFoodtype());
            pstmt.setInt(6, food.getQuantity());
            pstmt.setInt(7, food.getUser_id());
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

    public boolean addFoodForConsumer(Food food) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean updateState = false;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            // do not insert AuthorID, it is generated by Database
            pstmt = con.prepareStatement("INSERT INTO consumers_inventory (food_name, expiration_date, foodtype, quantity, consumer_id) " +
                    "VALUES(?, ?, ?, ?, ?)");
            pstmt.setString(1, food.getFoodName());
            pstmt.setTimestamp(2, food.getExpiration_date());
            pstmt.setString(3, food.getFoodtype());
            pstmt.setInt(4, food.getQuantity());
            pstmt.setInt(5, food.getUser_id());
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
            pstmt = con.prepareStatement("SELECT id, food_name, expiration_date, donated, price, discount, foodtype, quantity, retailer_id " +
                    "FROM retailer_inventory WHERE id = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                food = new Food();
                food.setId(rs.getInt("id"));
                food.setFoodName(rs.getString("food_name"));
                food.setExpiration_date(rs.getTimestamp("expiration_date"));
                food.setDonated(rs.getBoolean("donated"));
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
            pstmt = con.prepareStatement("UPDATE retailer_inventory SET food_name = ?, expiration_date = ?, donated = ?, price = ?, discount = ?, foodtype = ?, quantity = ? " +
                    "WHERE id = ?");
            pstmt.setString(1, food.getFoodName());
            pstmt.setTimestamp(2, food.getExpiration_date());
            pstmt.setBoolean(3, food.isDonated());
            pstmt.setDouble(4, food.getPrice());
            pstmt.setInt(5, food.getDiscount());
            pstmt.setString(6, food.getFoodtype());
            pstmt.setInt(7, food.getQuantity());
            pstmt.setInt(8, food.getId());

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
            pstmt = con.prepareStatement("UPDATE retailer_inventory SET donated = true " +
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

    public boolean claimFood(int foodId, int loggedInUserId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean claimState = false;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement("UPDATE retailer_inventory SET claimed_by = ?, claimed = TRUE WHERE id = ?");
            pstmt.setInt(1, loggedInUserId);
            pstmt.setInt(2, foodId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                claimState = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources and handle exceptions if necessary
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return claimState;
    }


}
