package VendingMachineTest.VendingMachineStateTest;

import VendingMachine.Snack;
import VendingMachine.VendingMachine;
import VendingMachine.VendingMachineStates.IdleState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IdleStateTest {

    private VendingMachine vendingMachine;
    private IdleState idleState;

    @BeforeEach
    public void setUp() {
        vendingMachine = new VendingMachine();
        idleState = new IdleState(vendingMachine);
    }

    @Test
    public void testSelectValidSnack() {
        idleState.selectSnack("Coke");
        assertNotNull(vendingMachine.getSelectedSnack(),
                "Selected snack should be set");
    }

    @Test
    public void testSelectInvalidSnack() {
        idleState.selectSnack("Unknown");
        assertNull(vendingMachine.getSelectedSnack(),
                "Selected snack should remain null");
    }
}
