package validation;

import model.users.User;

public class UserValidation extends Validation {
    public static final int USERNAME_MIN_LENGTH = 3;
    public static final int USERNAME_MAX_LENGTH = 100;
    public static final int PASSWORD_MIN_LENGTH = 5;
    public static final int PASSWORD_MAX_LENGTH = 100;
    public static String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static Message validateUser(User user) {
        // Message with validation state and error messages
        Message message = new Message("", true);

        // validate the username
        Message validationMessage = Validation.validateString(user.getUsername(), "username", USERNAME_MIN_LENGTH, USERNAME_MAX_LENGTH);
        if (!validationMessage.getState()) {
            message.setState(false);
            message.setValue(validationMessage.getValue());
        }

        // validate the password
        validationMessage = Validation.validateString(user.getPassword(), "password", PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH);
        if (!validationMessage.getState()) {
            message.setState(false);
            message.setValue(message.getValue() + validationMessage.getValue());
        }

        // validate the email
        validationMessage = Validation.validateRegex(user.getEmail(), "email", EMAIL_REGEX, "johndoe@gmail.com");
        if (!validationMessage.getState()) {
            message.setState(false);
            message.setValue(message.getValue() + validationMessage.getValue());
        }

        return message;
    }
}
