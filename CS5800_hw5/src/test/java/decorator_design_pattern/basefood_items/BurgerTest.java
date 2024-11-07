package decorator_design_pattern.basefood_items;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BurgerTest {

    @Test
    public void testCost() {
        Burger burger = new Burger();
        float expectedCost = 10.0f; // New base cost for Burger
        float actualCost = burger.cost();
        assertEquals(expectedCost, actualCost, 0.01f); // tolerance for floating-point calculations
    }

    @Test
    public void testFoodItemName() {
        Burger burger = new Burger();
        String expectedName = "Burger (base food)";
        String actualName = burger.foodItemName();
        assertEquals(expectedName, actualName);
    }
}
