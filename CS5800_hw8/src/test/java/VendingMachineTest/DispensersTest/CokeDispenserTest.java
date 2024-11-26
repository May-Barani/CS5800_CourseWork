package VendingMachineTest.DispensersTest;

import VendingMachine.Snack;
import VendingMachine.VendingMachine;
import VendingMachine.Dispensers.CokeDispenser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CokeDispenserTest {

    private VendingMachine vendingMachine;
    private Snack coke;
    private CokeDispenser cokeDispenser;

    @BeforeEach
    public void setUp() {
        vendingMachine = new VendingMachine();
        coke = new Snack("Coke", 2.25, 10);
        vendingMachine.getSnacks().put("Coke", coke);
        cokeDispenser = new CokeDispenser();
    }

    @Test
    public void testDispenseCokeSufficientFundsAndStock() {
        cokeDispenser.handleRequest(vendingMachine, coke, 3.00);
        assertEquals(9, coke.getQuantity(), "Coke quantity should decrement by 1");
    }

    @Test
    public void testDispenseCokeInsufficientFunds() {
        cokeDispenser.handleRequest(vendingMachine, coke, 1.50);
        assertEquals(10, coke.getQuantity(), "Coke quantity should remain the same");
    }

    @Test
    public void testDispenseCokeOutOfStock() {
        coke.setQuantity(0);
        cokeDispenser.handleRequest(vendingMachine, coke, 3.00);
        assertEquals(0, coke.getQuantity(), "Coke quantity should remain 0");
    }
}
