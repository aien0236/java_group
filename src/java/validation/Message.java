package validation;

public class Message {
    private String value;
    private boolean state;
    public Message(String value, boolean state) {
        this.value = value;
        this.state = state;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
