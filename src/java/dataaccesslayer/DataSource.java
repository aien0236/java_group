/* File: SwingMVCDemo.java
 * Author: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern, MVC Design Pattern
 * References:
 * Ram N. (2013).  Data Access Object Design Pattern or DAO Pattern [blog] Retrieved from
 * http://ramj2ee.blogspot.in/2013/08/data-access-object-design-pattern-or.html
 */
//package dataaccesslayer;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
//public class DataSource {
//
//    private static Connection connection = null;
//    private static String url = null;
//    private static String username = null;
//    private static String password = null;
//
//    public DataSource() {
//    }
//
//    public static void loadProperties() {
//        Properties props = new Properties();
////        try (InputStream in = ClassLoader.getSystemResourceAsStream("database.properties")) {
////            props.load(in);
////        try (InputStream in = Files.newInputStream(Paths.get("database.properties"))) {
////            props.load(in);
//        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties")) {
//            props.load(in);
//            System.out.println("Success to load database properties");
//        } catch (Exception e) {
//            System.out.println("Failed to load database properties");
//            e.printStackTrace();
//        }
//        url = props.getProperty("url");
//        username = props.getProperty("username");
//        password = props.getProperty("password");
//        System.out.println(url);
//        System.out.println(username);
//        System.out.println(password);
//
//
//    }
//
//    /*
// * Only use one connection for this application, prevent memory leaks.
//     */
//    public static Connection createConnection() throws SQLException {
//        try {
//            if (connection != null) {
//                System.out.println("Cannot create new connection, one exists already");
//            } else {
//                if (url == null) {
//                    loadProperties();
//                }
//                connection = DriverManager.getConnection(url, username, password);
//                System.out.println("Connection success");
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            throw ex;
//        }
//        return connection;
//    }
//}
/* File: SwingMVCDemo.java
 * Author: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern, MVC Design Pattern
 * References:
 * Ram N. (2013).  Data Access Object Design Pattern or DAO Pattern [blog] Retrieved from
 * http://ramj2ee.blogspot.in/2013/08/data-access-object-design-pattern-or.html
 */
package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private Connection connection = null;

    public DataSource() {
    }

    /*
     * Only use one connection for this application, prevent memory leaks.
     */
    public Connection createConnection() throws SQLException {
        try {
            if (connection != null) {
                System.out.println("Cannot create new connection, one exists already");
            } else {
                String url = "jdbc:mysql://localhost:3306/fwrp";
                String username = "fwrp";
                String password = "fwrp";
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return connection;
    }
}
