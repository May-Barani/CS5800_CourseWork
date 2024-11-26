package VendingMachineTest;

import VendingMachine.VendingMachineStates.IdleState;
import VendingMachine.Snack;
import VendingMachine.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @BeforeEach
    public void setUp() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void testInitializeSnacks() {
        assertEquals(6, vendingMachine.getSnacks().size(),
                "There should be 6 snacks initialized");
    }

    @Test
    public void testSelectValidSnackAndInsertMoney() {
        Snack coke = new Snack("Coke", 2.25, 10);
        vendingMachine.getSnacks().put("Coke", coke);
        vendingMachine.selectAndInsertMoney("Coke", 3.00);

        assertEquals(9, coke.getQuantity(), "Coke quantity should decrement by 1");
        assertEquals(0, vendingMachine.getInsertedMoney(),
                "Inserted money should reset after dispensing");
    }


    @Test
    public void testSelectInvalidSnack() {
        vendingMachine.selectAndInsertMoney("Unknown", 3.00);
        assertEquals(0, vendingMachine.getInsertedMoney(),
                "Inserted money should remain 0");
    }
}
