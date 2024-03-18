//package dataaccesslayer;
//
//import org.junit.jupiter.api.Test;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class DataSourceTest {
//
//    @Test
//    public void testConnection() {
//        try {
//            Connection conn = DataSource.createConnection();
//            assertNotNull(conn, "Connection shouldn't be null");
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//        }
//
//    }
//}