package PizzaOrderPattern;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    void testEatMethodOutput() {
        // Arrange: Create a Pizza object with expected details
        Pizza pizza = new Pizza("Pizza Hut", "large", List.of("Pepperoni", "Mushrooms", "Onions"));

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act: Call eat method
        pizza.eat();

        // Reset System.out
        System.setOut(System.out);

        // Assert: Verify the output contains the expected details
        String output = outputStream.toString();
        assertTrue(output.contains("Pizza Hut"), "Output should contain the pizza chain name.");
        assertTrue(output.contains("large"), "Output should contain the pizza size.");
        assertTrue(output.contains("3 toppings"), "Output should mention the correct number of toppings.");
        assertTrue(output.contains("Pepperoni"), "Output should contain 'Pepperoni' as a topping.");
        assertTrue(output.contains("Mushrooms"), "Output should contain 'Mushrooms' as a topping.");
        assertTrue(output.contains("Onions"), "Output should contain 'Onions' as a topping.");
    }
}
