package decorator_design_pattern.toppings_decorator;

import decorator_design_pattern.basefood_items.Burger;
import decorator_design_pattern.basefood_items.FoodItems;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExtraCheeseTest {

    @Test
    public void testCost() {
        FoodItems burger = new Burger();  // Burger (10)
        ExtraCheese extraCheese = new ExtraCheese(burger);

        float expectedCost = 13.0f; // 10 (Burger) + 3 (Extra Cheese)
        float actualCost = extraCheese.cost();

        assertEquals(expectedCost, actualCost, 0.01f);
    }

    @Test
    public void testFoodItemName() {
        FoodItems burger = new Burger();
        ExtraCheese extraCheese = new ExtraCheese(burger);

        String expectedName = "Burger (base food), Extra Cheese (toppings)";
        String actualName = extraCheese.foodItemName();

        assertEquals(expectedName, actualName);
    }
}
