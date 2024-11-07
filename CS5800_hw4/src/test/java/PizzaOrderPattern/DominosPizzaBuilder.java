package PizzaOrderPattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DominosPizzaBuilderTest {

    @Test
    void testDominosBuilderSetsAttributesCorrectly() {
        // Arrange
        DominosPizzaBuilder builder = new DominosPizzaBuilder();

        // Act
        Pizza pizza = builder.setPizzaChainName("Dominos")
                .setPizzaSize("small")
                .setPizzaToppingsList("Extra Cheese")
                .build();

        // Assert
        assertEquals("Dominos", pizza.getPizzaChainName(), "Pizza chain name should be Dominos.");
        assertEquals("small", pizza.getPizzaSize(), "Pizza size should be small.");
        assertEquals(1, pizza.getPizzaToppingsList().size(), "Pizza should have 1 topping.");
        assertTrue(pizza.getPizzaToppingsList().contains("Extra Cheese"), "Toppings should include 'Extra Cheese'.");
    }
}
