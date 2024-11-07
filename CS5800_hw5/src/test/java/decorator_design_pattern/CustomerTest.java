package decorator_design_pattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    public void testSetAndGetCustomerName() {
        Customer customer = new Customer("Alexa", 3, new Order());
        String expectedName = "Alice Smith";
        customer.setCustomerName(expectedName);
        assertEquals(expectedName, customer.getCustomerName());
    }

    @Test
    public void testSetCustomerNameWithNull() {
        Customer customer = new Customer("Alexa", 3, new Order());
        customer.setCustomerName(null);
        assertNull(customer.getCustomerName());
    }

    @Test
    public void testSetAndGetCustomerLoyaltyStatus() {
        Customer customer = new Customer("Alexa", 3, new Order());
        int expectedStatus = 5;
        customer.setCustomerLoyaltyStatus(expectedStatus);
        assertEquals(expectedStatus, customer.getCustomerLoyaltyStatus());
    }

    @Test
    public void testSetAndGetOrder() {
        Customer customer = new Customer("Alexa", 3, new Order());
        Order expectedOrder = new Order();
        customer.setOrder(expectedOrder);
        assertEquals(expectedOrder, customer.getOrder());
    }
}
