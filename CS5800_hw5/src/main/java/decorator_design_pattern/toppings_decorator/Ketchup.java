package decorator_design_pattern.toppings_decorator;
import decorator_design_pattern.basefood_items.FoodItems;
public class Ketchup extends ToppingsDecorator {

    FoodItems foodItems;

    public Ketchup(FoodItems foodItems) {
        this.foodItems = foodItems;
    }

    @Override
    public float cost() {
        return foodItems.cost() + 0.5f;
    }

    @Override
    public String foodItemName() {
        return foodItems.foodItemName() + ", Ketchup (toppings)";
    }
}
