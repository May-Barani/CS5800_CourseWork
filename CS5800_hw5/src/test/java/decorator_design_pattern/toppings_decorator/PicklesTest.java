package decorator_design_pattern.toppings_decorator;

import decorator_design_pattern.basefood_items.Burger;
import decorator_design_pattern.basefood_items.FoodItems;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PicklesTest {

    @Test
    public void testCost() {
        FoodItems burger = new Burger();  // Burger (10)
        Pickles pickles = new Pickles(burger);

        float expectedCost = 11.5f; // 10 (Burger) + 1.5 (Pickles)
        float actualCost = pickles.cost();

        assertEquals(expectedCost, actualCost, 0.01f);
    }

    @Test
    public void testFoodItemName() {
        FoodItems burger = new Burger();
        Pickles pickles = new Pickles(burger);

        String expectedName = "Burger (base food), Pickles (toppings)";
        String actualName = pickles.foodItemName();

        assertEquals(expectedName, actualName);
    }
}
