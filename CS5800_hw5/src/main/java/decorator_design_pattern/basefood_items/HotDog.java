package decorator_design_pattern.basefood_items;

public class HotDog implements FoodItems {

    @Override
    public float cost() {
        return 8;
    }

    @Override
    public String foodItemName() {
        return "HotDog (base food)";
    }
}
