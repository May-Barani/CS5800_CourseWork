package PizzaOrderPattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PizzaHutPizzaBuilderTest {

    @Test
    void testPizzaHutBuilderSetsAttributesCorrectly() {
        // Arrange
        PizzaHutPizzaBuilder builder = new PizzaHutPizzaBuilder();

        // Act
        Pizza pizza = builder.setPizzaChainName("Pizza Hut")
                .setPizzaSize("large")
                .setPizzaToppingsList("Pepperoni", "Mushrooms", "Onions")
                .build();

        // Assert
        assertEquals("Pizza Hut", pizza.getPizzaChainName(), "Pizza chain name should be Pizza Hut.");
        assertEquals("large", pizza.getPizzaSize(), "Pizza size should be large.");
        assertEquals(3, pizza.getPizzaToppingsList().size(), "Pizza should have 3 toppings.");
        assertTrue(pizza.getPizzaToppingsList().contains("Pepperoni"), "Toppings should include 'Pepperoni'.");
    }
}
