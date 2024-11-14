package decorator_design_pattern.toppings_decorator;

import decorator_design_pattern.basefood_items.Burger;
import decorator_design_pattern.basefood_items.FoodItems;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LettuceTest {

    @Test
    public void testCost() {
        FoodItems burger = new Burger();  // Burger (10)
        Lettuce lettuce = new Lettuce(burger);

        float expectedCost = 11.0f; // 10 (Burger) + 1 (Lettuce)
        float actualCost = lettuce.cost();

        assertEquals(expectedCost, actualCost, 0.01f);
    }

    @Test
    public void testFoodItemName() {
        FoodItems burger = new Burger();
        Lettuce lettuce = new Lettuce(burger);

        String expectedName = "Burger (base food), Lettuce (toppings)";
        String actualName = lettuce.foodItemName();

        assertEquals(expectedName, actualName);
    }
}
