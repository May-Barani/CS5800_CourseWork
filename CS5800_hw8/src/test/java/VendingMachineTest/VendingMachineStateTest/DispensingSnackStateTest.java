package VendingMachineTest.VendingMachineStateTest;

import VendingMachine.Snack;
import VendingMachine.VendingMachine;
import VendingMachine.VendingMachineStates.DispensingSnackState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DispensingSnackStateTest {

    private VendingMachine vendingMachine;
    private Snack coke;
    private DispensingSnackState dispensingState;

    @BeforeEach
    public void setUp() {
        vendingMachine = new VendingMachine();
        coke = new Snack("Coke", 2.25, 10);
        vendingMachine.getSnacks().put("Coke", coke);
        vendingMachine.setSelectedSnack(coke);
        vendingMachine.setInsertedMoney(3.00);
        dispensingState = new DispensingSnackState(vendingMachine);
    }
    @Test
    public void testDispenseSnack() {
        assertNotNull(vendingMachine.getSelectedSnack(), "Selected snack should not be null.");
        assertTrue(vendingMachine.getInsertedMoney() >= coke.getPrice(), "Inserted money should be sufficient.");
        dispensingState.dispenseSnack();
        assertEquals(9, coke.getQuantity(), "Coke quantity should decrement by 1.");
    }

    @Test
    public void testNotEnoughMoney() {
        vendingMachine.setInsertedMoney(1.00);
        dispensingState.dispenseSnack();
        assertEquals(10, coke.getQuantity(),
                "Coke quantity should remain the same");
    }
}
