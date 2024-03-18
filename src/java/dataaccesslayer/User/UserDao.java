package dataaccesslayer.User;


import model.users.Consumer;
import model.users.Retailer;
import model.users.User;
import model.users.Organization;

import java.util.List;

public abstract class UserDao {
    abstract List<User> getAllUsers();

    abstract boolean createUser(User user);

    abstract void updateUser(User user);

    abstract User getUser(User user);

    abstract void deleteUser(User user);

    User getUserByType(String userType) {
        User user = null;
        switch (userType) {
            case "Consumer":
                user = new Consumer();
                user.setUserType("" + User.USER_TYPES.CONSUMER);
                break;
            case "Retailer":
                user = new Retailer();
                user.setUserType("" + User.USER_TYPES.RETAILER);
                break;
            case "Organization":
                user = new Organization();
                user.setUserType("" + User.USER_TYPES.CHARITY);
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return user;
    }


}
