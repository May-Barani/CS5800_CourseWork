package decorator_design_pattern.toppings_decorator;

import decorator_design_pattern.basefood_items.FoodItems;

public class Pickles extends ToppingsDecorator {

    FoodItems foodItems;

    public Pickles (FoodItems foodItems) {
        this.foodItems = foodItems;
    }

    @Override
    public float cost() {
        return foodItems.cost() + 1.5f;
    }

    @Override
    public String foodItemName() {
        return foodItems.foodItemName() + ", Pickles (toppings)";
    }
}
