package PizzaOrderPattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LittleCaesarsPizzaBuilderTest {

    @Test
    void testLittleCaesarsBuilderSetsAttributesCorrectly() {
        // Arrange
        LittleCaesarsPizzaBuilder builder = new LittleCaesarsPizzaBuilder();

        // Act
        Pizza pizza = builder.setPizzaChainName("Little Caesars")
                .setPizzaSize("medium")
                .setPizzaToppingsList("Pepperoni", "Sausage", "Olives", "Onions")
                .build();

        // Assert
        assertEquals("Little Caesars", pizza.getPizzaChainName(), "Pizza chain name should be Little Caesars.");
        assertEquals("medium", pizza.getPizzaSize(), "Pizza size should be medium.");
        assertEquals(4, pizza.getPizzaToppingsList().size(), "Pizza should have 4 toppings.");
        assertTrue(pizza.getPizzaToppingsList().contains("Pepperoni"), "Toppings should include 'Pepperoni'.");
        assertTrue(pizza.getPizzaToppingsList().contains("Sausage"), "Toppings should include 'Sausage'.");
    }
}
