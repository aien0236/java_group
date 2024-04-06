package dataaccesslayer.User;


import dataaccesslayer.DataSource;
import dataaccesslayer.User.UserDao;
import model.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends UserDao {


    /**
     * Returns a list of all users in the database
     *
     * @return all users
     */
    @Override
    public List<User> getAllUsers() {
        // declare variables
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<User> users = null;
        try {
            // create and execute query to get all users
            DataSource ds = new DataSource();
            conn = ds.createConnection();
            String query = "SELECT * FROM user";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            users = new ArrayList<User>();
            // iterate over each row adding a user to the user list
            while (rs.next()) {
                User user;
                user = getUserByType(rs.getString("studentType"));
                user.setUsername(rs.getString("user_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        } finally {
            // close resources
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {

                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return users;
    }

    @Override
    public boolean createUser(User user) {
        // declare variables
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean userAdded = false;
        try {
            // create connection and query
            DataSource ds = new DataSource();
            conn = ds.createConnection();
            String query = "INSERT INTO USER (user_name, email, password, userType) " +
                    "VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getUserType());

            // execute insert
            int rowsAffected = pstmt.executeUpdate();

            // check to see if the query worked without errors
            if (rowsAffected > 0) {
                System.out.println("User added successfully");
                userAdded = true;
            } else {
                System.out.println("Failed to add user");
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            // close resources
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return userAdded;
    }

    @Override
    public void updateUser(User user) {
        // declare variables
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // create connection and query
            DataSource ds = new DataSource();
            conn = ds.createConnection();
            String query = "UPDATE USER SET user_name = ?, email = ?, password = ?, userType = ?" +
                    "WHERE email = ? AND passsword = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getUserType());
            pstmt.setString(5, user.getPassword());
            // execute insert
            int rowsAffected = pstmt.executeUpdate();

            // check to see if the query worked without errors
            if (rowsAffected > 0) {
                System.out.println("User updated successfully");
            } else {
                System.out.println("Failed to update user");
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            // close resources
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public User getUser(User user) {
        // declare variables
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User userFetch = null;
        try {
            // create connection and query
            DataSource ds = new DataSource();
            conn = ds.createConnection();
            String query = "SELECT * FROM USER WHERE email = ? OR user_name = ? AND password = ? LIMIT 1";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());

            // execute insert
            rs = pstmt.executeQuery();

            // populate user and return user
            if (rs.next()) {

                userFetch = getUserByType(rs.getString("usertype"));
                userFetch.setId(rs.getInt("id"));
                userFetch.setUsername(rs.getString("user_name"));
                userFetch.setEmail(rs.getString("email"));
                userFetch.setPassword(rs.getString("password"));
                return userFetch;
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            // close resources
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        // user not found
        return null;
    }

    @Override
    public void deleteUser(User user) {
        // declare variables
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // create connection and query
            DataSource ds = new DataSource();
            conn = ds.createConnection();
            String query = "DELETE FROM user WHERE email = ? AND password = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPassword());

            // execute insert
            int rowsAffected = pstmt.executeUpdate();

            // verify that a user was deleted
            if (rowsAffected > 0) {
                System.out.println("User was successfully deleted");
            } else {
                System.out.println("User was not deleted");
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            // close resources
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
