package dataaccesslayer.User;

import businesslayer.UserBusinessLogic;
import model.users.Retailer;
import model.users.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {

    @Test
    public void testGetUser() {
        UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
        // change these to a user existing in the database...
        String username = "matt123",
                email = "matt@gmail.com",
                password = "matt123";
        User user = new Retailer();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setUserType("Retailer");

        User userDB = userBusinessLogic.getUser(user);
        System.out.println("User to string...");
        System.out.println(userDB.toString());
        assertEquals(username, userDB.getUsername(), "Username is not what it should be");
    }

}