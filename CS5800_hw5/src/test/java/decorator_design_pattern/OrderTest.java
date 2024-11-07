package decorator_design_pattern;

import decorator_design_pattern.basefood_items.*;
import decorator_design_pattern.toppings_decorator.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    public void testCalculateOrderCostWithDiscountAndLoyaltyStatus5() {
        Order orderCalculator = new Order();
        List<FoodItems> items = new ArrayList<>();
        items.add(new ExtraCheese(new Burger()));  // Burger (10) + Extra Cheese (3) = 13
        orderCalculator.setCustomerFoodItems(items);

        double expectedCost = 13.0 * (1 - 0.12); // 12% discount for loyalty status 5
        double actualCost = orderCalculator.calculateOrderCostWithDiscountBasedOnCustomerLoyaltyStatus(5);
        assertEquals(expectedCost, actualCost, 0.01);
    }

    @Test
    public void testCalculateOrderCostWithDiscountAndLoyaltyStatus4() {
        Order orderCalculator = new Order();
        List<FoodItems> items = new ArrayList<>();
        items.add(new Ketchup(new Fries()));  // Fries (5) + Ketchup (0.5) = 5.5
        orderCalculator.setCustomerFoodItems(items);

        double expectedCost = 5.5 * (1 - 0.10); // 10% discount for loyalty status 4
        double actualCost = orderCalculator.calculateOrderCostWithDiscountBasedOnCustomerLoyaltyStatus(4);
        assertEquals(expectedCost, actualCost, 0.01);
    }

    @Test
    public void testCalculateOrderCostWithDiscountAndLoyaltyStatus3() {
        Order orderCalculator = new Order();
        List<FoodItems> items = new ArrayList<>();
        items.add(new Pickles(new ExtraCheese(new Burger())));  // Burger (10) + Extra Cheese (3) + Pickles (1.5) = 14.5
        items.add(new Ketchup(new Fries()));  // Fries (5) + Ketchup (0.5) = 5.5
        orderCalculator.setCustomerFoodItems(items);

        double totalCost = 14.5 + 5.5; // Total cost before discount
        double expectedCost = totalCost * (1 - 0.075); // 7.5% discount for loyalty status 3
        double actualCost = orderCalculator.calculateOrderCostWithDiscountBasedOnCustomerLoyaltyStatus(3);
        assertEquals(expectedCost, actualCost, 0.01);
    }

}
