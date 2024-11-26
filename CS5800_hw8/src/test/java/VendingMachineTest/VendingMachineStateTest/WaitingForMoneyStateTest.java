package VendingMachineTest.VendingMachineStateTest;

import VendingMachine.Snack;
import VendingMachine.VendingMachine;
import VendingMachine.VendingMachineStates.WaitingForMoneyState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WaitingForMoneyStateTest {

    private VendingMachine vendingMachine;
    private WaitingForMoneyState waitingState;

    @BeforeEach
    public void setUp() {
        vendingMachine = new VendingMachine();
        waitingState = new WaitingForMoneyState(vendingMachine);
        Snack coke = new Snack("Coke", 2.25, 10);
        vendingMachine.getSnacks().put("Coke", coke);
        vendingMachine.setSelectedSnack(coke);
    }

    @Test
    public void testInsertSufficientMoney() {
        waitingState.insertMoney(3.00);
        assertEquals(3.00, vendingMachine.getInsertedMoney(),
                "Inserted money should be recorded");
    }

    @Test
    public void testInsertInsufficientMoney() {
        waitingState.insertMoney(1.00);
        assertEquals(1.00, vendingMachine.getInsertedMoney(),
                "Inserted money should remain as it is");
    }
}
