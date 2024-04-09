import businesslayer.UserBusinessLogic;
import dataaccesslayer.DataSource;
import model.users.Consumer;
import model.users.User;
import schedule.SubSchedule;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class main {
    public static void main(String[] args) {
        User user = new Consumer();
        user.setUsername("username123");
        user.setPassword("password123");
        user.setEmail("fakemail123@gmail.com");
        user.setUserType("Consumer");
        UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
        userBusinessLogic.createUser(user);
//        SubSchedule subSchedule = new SubSchedule();
    }
}
