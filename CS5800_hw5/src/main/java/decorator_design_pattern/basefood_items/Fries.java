package decorator_design_pattern.basefood_items;

public class Fries implements FoodItems {

    @Override
    public float cost() {
        return 5;
    }

    @Override
    public String foodItemName() {
        return "Fries (base food)";
    }
}
