package model.users;

public abstract class User {
    protected String username;
    protected String email;
    protected String password;
    protected String userType;

    public enum USER_TYPES {
        CONSUMER,
        RETAILER,
        CHARITY
    }

    public User() {

    }

    public User(String username, String email, String password, String userType) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * Returns a string representation of the user object. Can be used for testing purposes.
     *
     * @return
     */
    public String toString() {
        return "User: [ " + username + ", " + email + ", " + password + ", " + userType + " ]";
    }
}

