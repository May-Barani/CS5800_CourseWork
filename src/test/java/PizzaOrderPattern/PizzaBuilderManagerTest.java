package PizzaOrderPattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PizzaBuilderManagerTest {

    @Test
    void testConstructSmallPizzaOfPizzaHut() {
        // Arrange
        PizzaBuilderManager manager = new PizzaBuilderManager();

        // Act
        Pizza pizza = manager.constructSmallPizzaOfPizzaHut(new PizzaHutPizzaBuilder());

        // Assert
        assertEquals("Pizza Hut", pizza.getPizzaChainName(), "Pizza chain name should be Pizza Hut.");
        assertEquals("small", pizza.getPizzaSize(), "Pizza size should be small.");
        assertEquals(3, pizza.getPizzaToppingsList().size(), "Pizza should have 3 toppings.");
        assertTrue(pizza.getPizzaToppingsList().contains("Ham and Pineapple"), "Toppings should include 'Ham and Pineapple'.");
        assertTrue(pizza.getPizzaToppingsList().contains("Bacon"), "Toppings should include 'Bacon'.");
        assertTrue(pizza.getPizzaToppingsList().contains("Extra Cheese"), "Toppings should include 'Extra Cheese'.");
    }
}
