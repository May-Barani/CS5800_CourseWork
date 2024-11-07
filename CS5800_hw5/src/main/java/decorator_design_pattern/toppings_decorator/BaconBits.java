package decorator_design_pattern.toppings_decorator;

import decorator_design_pattern.basefood_items.FoodItems;

public class BaconBits extends ToppingsDecorator {

    FoodItems foodItems;

    public BaconBits(FoodItems foodItems) {
        this.foodItems = foodItems;
    }

    @Override
    public float cost() {
        return foodItems.cost() + 4;
    }

    @Override
    public String foodItemName() {
        return foodItems.foodItemName() + ", Bacon Bits (toppings)";
    }
}
