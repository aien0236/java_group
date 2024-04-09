package validation;

public class Validation {
    public static Message validateString(String value, String field, int minLength, int maxLength) {
        Message message = new Message("", true);
        if (value.length() < minLength) {
            message.setValue("<p class = 'text-red-700'>" + field + " length is too short (less than " + minLength + " characters)</p>");
            message.setState(false);
        } else if (value.length() > maxLength) {
            message.setValue("<p class = 'text-red-700'>" + field + " length is too long (more than " + maxLength + " characters)</p>");
            message.setState(false);
        }

        return message;
    }

    /**
     * Returns a message object which indicates the error state with a message value
     *
     * @param value  the value to test
     * @param field  the name of the string field. Ex. foodName
     * @param regex  the regex to compare against the value
     * @param format the expected format for the error message
     * @return
     */
    public static Message validateRegex(String value, String field, String regex, String format) {
        Message message = new Message("", true);
        System.out.println("testere.re.r.e");
        System.out.println(value.matches(regex));
        // if regex doesn't match
        if (!value.matches(regex)) {
            message.setState(false);
            message.setValue("<p class = 'text-red-700' >" + field + " does not match format of " + format + "</p>");
        }
        return message;
    }

    /**
     * Returns a message indicating true/false if the string is empty and contains a message
     *
     * @param string the string to be validated
     * @param field  the name of the string name. Ex. 'foodName'
     * @return Message that represents the string validation
     */
    public static Message stringNotEmpty(String string, String field) {
        Message message = new Message("", true);
        if (string.isEmpty()) {
            message.setState(false);
            message.setValue("<p class = 'text-red-700'>" + field + " has length of 0 </p>");
        } else if (string == null) {
            message.setState(false);
            message.setValue("<p class = 'text-red-700'>" + field + " has a null value </p>");
        }
        return message;
    }

    /**
     * Checks to see if the provided num is empty. It is empty if it has a value of -1
     *
     * @param num   the number to check if it's empty
     * @param field the field that is checked to see if the number is empty. Ex. quantity
     * @return
     */
    public static Message numNotEmpty(int num, String field) {
        Message message = new Message("", true);
        if (num == -1) {
            message.setState(false);
            message.setValue("<p class = 'text-red-700'>" + field + " has a value of -1 indicating the field was empty </p>");
        }
        return message;
    }
}
