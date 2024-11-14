package decorator_design_pattern.toppings_decorator;

import decorator_design_pattern.basefood_items.Burger;
import decorator_design_pattern.basefood_items.FoodItems;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaconBitsTest {

    @Test
    public void testCost() {
        FoodItems burger = new Burger();  // Burger (10)
        BaconBits baconBits = new BaconBits(burger);

        float expectedCost = 14.0f; // 10 (Burger) + 4 (Bacon Bits)
        float actualCost = baconBits.cost();

        assertEquals(expectedCost, actualCost, 0.01f);
    }

    @Test
    public void testFoodItemName() {
        FoodItems burger = new Burger();
        BaconBits baconBits = new BaconBits(burger);

        String expectedName = "Burger (base food), Bacon Bits (toppings)";
        String actualName = baconBits.foodItemName();

        assertEquals(expectedName, actualName);
    }
}
