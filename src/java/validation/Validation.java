package validation;

public class Validation {
    public static Message validateString(String value, String field, int minLength, int maxLength) {
        Message message = new Message("", true);
        if (value.length() <  minLength) {
            message.setValue("<p>" + field + " length is too short (less than " + minLength + " characters)</p>");
            message.setState(false);
        } else if (value.length() > maxLength) {
            message.setValue("<p>" + field + " length is too long (more than " + maxLength + " characters)</p>");
            message.setState(false);
        }

        return message;
    }

    public static Message validateRegex(String value, String field, String regex, String format) {
        Message message = new Message("", true);
        System.out.println("testere.re.r.e");
        System.out.println(value.matches(regex));
        // if regex doesn't match
        if (!value.matches(regex)) {
            message.setState(false);
            message.setValue("<p>" + field + " does not match format of " + format + "</p>");
        }
        return message;
    }
}
