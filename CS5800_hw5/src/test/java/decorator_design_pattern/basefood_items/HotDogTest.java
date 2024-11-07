package decorator_design_pattern.basefood_items;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HotDogTest {

    @Test
    public void testCost() {
        HotDog hotDog = new HotDog();
        float expectedCost = 8.0f; // New base cost for HotDog
        float actualCost = hotDog.cost();
        assertEquals(expectedCost, actualCost, 0.01f); // tolerance for floating-point calculations
    }

    @Test
    public void testFoodItemName() {
        HotDog hotDog = new HotDog();
        String expectedName = "HotDog (base food)";
        String actualName = hotDog.foodItemName();
        assertEquals(expectedName, actualName);
    }
}
