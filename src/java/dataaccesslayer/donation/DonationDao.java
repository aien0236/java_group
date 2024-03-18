package dataaccesslayer.donation;

import model.food.Food;
import model.users.Organization;

public interface DonationDao {
    public void donateFood(Food food);

    public void claimFoodDonation(Food food, Organization organization);
}
