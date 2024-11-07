package decorator_design_pattern;

import decorator_design_pattern.basefood_items.FoodItems;
import java.util.List;

public class Order {

    private List<FoodItems> customerFoodItems;

    public List<FoodItems> getCustomerFoodItems() {
        return customerFoodItems;
    }

    public void setCustomerFoodItems(List<FoodItems> customerFoodItems) {
        this.customerFoodItems = customerFoodItems;
    }

    public double getDiscount(int customerLoyaltyStatus) {
        switch (customerLoyaltyStatus) {
            case 5: return 0.12;
            case 4: return 0.10;
            case 3: return 0.075;
            case 2: return 0.050;
            case 1: return 0.030;
            default: return 0;
        }
    }

    public double calculateOrderCostWithDiscountBasedOnCustomerLoyaltyStatus(int customerLoyaltyStatus) {
        double totalCost = 0;
        for (FoodItems foodItems : customerFoodItems) {
            totalCost += foodItems.cost();
        }
        double discount = getDiscount(customerLoyaltyStatus);
        return totalCost * (1 - discount);
    }
}
