package decorator_design_pattern.toppings_decorator;

import decorator_design_pattern.basefood_items.Burger;
import decorator_design_pattern.basefood_items.FoodItems;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KetchupTest {

    @Test
    public void testCost() {
        FoodItems burger = new Burger();  // Burger (10)
        Ketchup ketchup = new Ketchup(burger);

        float expectedCost = 10.5f; // 10 (Burger) + 0.5 (Ketchup)
        float actualCost = ketchup.cost();

        assertEquals(expectedCost, actualCost, 0.01f);
    }

    @Test
    public void testFoodItemName() {
        FoodItems burger = new Burger();
        Ketchup ketchup = new Ketchup(burger);

        String expectedName = "Burger (base food), Ketchup (toppings)";
        String actualName = ketchup.foodItemName();

        assertEquals(expectedName, actualName);
    }
}
