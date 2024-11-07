package decorator_design_pattern.basefood_items;

public class Burger implements FoodItems {

    @Override
    public float cost() {
        return 10;
    }

    @Override
    public String foodItemName() {
        return "Burger (base food)";
    }
}
