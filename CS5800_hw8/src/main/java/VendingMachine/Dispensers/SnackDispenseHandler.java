package VendingMachine.Dispensers;

import VendingMachine.Snack;
import VendingMachine.VendingMachine;

public abstract class SnackDispenseHandler {
    protected SnackDispenseHandler nextHandler;

    public void setNextHandler(SnackDispenseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(VendingMachine machine, Snack selectedSnack, double insertedMoney);
}
