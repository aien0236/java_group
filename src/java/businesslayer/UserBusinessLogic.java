package businesslayer;

import dataaccesslayer.User.UserDao;
import dataaccesslayer.User.UserDaoImpl;
import model.users.User;

import java.util.List;

public class UserBusinessLogic {
    private UserDaoImpl userDao;

    public UserBusinessLogic() {
        this.userDao = new UserDaoImpl();
    }

    public User getUser(User user) {
        return userDao.getUser(user);
    }

    public boolean createUser(User user) {
        return userDao.createUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
