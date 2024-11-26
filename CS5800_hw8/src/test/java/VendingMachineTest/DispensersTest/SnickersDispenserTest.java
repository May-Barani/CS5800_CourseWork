package VendingMachineTest.DispensersTest;

import VendingMachine.Snack;
import VendingMachine.VendingMachine;
import VendingMachine.Dispensers.SnickersDispenser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnickersDispenserTest {

    private VendingMachine vendingMachine;
    private SnickersDispenser dispenser;

    @BeforeEach
    public void setUp() {
        vendingMachine = new VendingMachine();
        dispenser = new SnickersDispenser();
    }

    @Test
    public void testDispenseSnickersOutOfStock() {
        Snack snickers = new Snack("Snickers", 1.50, 0); // Out of stock
        vendingMachine.getSnacks().put("Snickers", snickers);
        vendingMachine.setInsertedMoney(1.00); // Inserted money

        dispenser.handleRequest(vendingMachine, snickers, 1.00);

        assertEquals(0, snickers.getQuantity(), "Snickers quantity should remain 0 as it is out of stock.");
        assertEquals(0, vendingMachine.getInsertedMoney(), "Inserted money should be reset after returning change.");
    }
}
