package model.subscription;



public class Subscription {
    private Long id;
    private Long userId;
    private String subscriberName;
    private String email;
    private String phone;
    private String foodPreferenceType;
    private String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFoodPreferenceType() {
        return foodPreferenceType;
    }

    public void setFoodPreferenceType(String foodPreferenceType) {
        this.foodPreferenceType = foodPreferenceType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
