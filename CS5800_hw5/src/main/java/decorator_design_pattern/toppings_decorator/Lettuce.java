package decorator_design_pattern.toppings_decorator;

import decorator_design_pattern.basefood_items.FoodItems;

public class Lettuce extends ToppingsDecorator {

    FoodItems foodItems;

    public Lettuce(FoodItems foodItems) {
        this.foodItems = foodItems;
    }

    @Override
    public float cost() {
        return foodItems.cost() + 1;
    }

    @Override
    public String foodItemName() {
        return foodItems.foodItemName() + ", Lettuce (toppings)";
    }
}
