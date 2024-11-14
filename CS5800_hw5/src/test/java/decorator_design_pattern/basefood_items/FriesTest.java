package decorator_design_pattern.basefood_items;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FriesTest {

    @Test
    public void testCost() {
        Fries fries = new Fries();
        float expectedCost = 5.0f; // New base cost for Fries
        float actualCost = fries.cost();
        assertEquals(expectedCost, actualCost, 0.01f); // tolerance for floating-point calculations
    }

    @Test
    public void testFoodItemName() {
        Fries fries = new Fries();
        String expectedName = "Fries (base food)";
        String actualName = fries.foodItemName();
        assertEquals(expectedName, actualName);
    }
}
