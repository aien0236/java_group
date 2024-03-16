package model.users;

public class UserFactory {
    public static User createUser(String userName, String email, String password, String userType) {
        User user;
        // create a user based on the given type
        switch (userType) {
            case "Retailer":
                user = new Retailer();
                break;
            case "Organization":
                user = new Organization();
                break;
            case "Consumer":
                user = new Consumer();
                break;
            default:
                throw new UnsupportedOperationException();
        }
        // set the user attributes
        user.setUsername(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setUserType(userType);

        return user;
    }
}
