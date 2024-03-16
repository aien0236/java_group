/* File: SwingMVCDemo.java
 * Author: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern, MVC Design Pattern
 * References:
 * Ram N. (2013).  Data Access Object Design Pattern or DAO Pattern [blog] Retrieved from
 * http://ramj2ee.blogspot.in/2013/08/data-access-object-design-pattern-or.html
 */
package dataaccesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {

    private static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/fwrp?useSSL=false&allowPublicKeyRetrieval=true";
    private static String username = "james";
    private static String password = "poophead";

    public DataSource() {
    }

    public static void loadProperties() {
        Properties props = new Properties();
        try (InputStream in = ClassLoader.getSystemResourceAsStream("/resources/database.properties")) {
            props.load(in);
        } catch (Exception e) {
            System.out.println("Failed to load database properties");
            e.printStackTrace();
        }
        url = props.getProperty("url");
        username = props.getProperty("username");
        password = props.getProperty("password");


    }

    /*
 * Only use one connection for this application, prevent memory leaks.
     */
    public static Connection createConnection() throws SQLException {
        try {
            if (connection != null) {
                System.out.println("Cannot create new connection, one exists already");
            } else {

                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return connection;
    }
}
