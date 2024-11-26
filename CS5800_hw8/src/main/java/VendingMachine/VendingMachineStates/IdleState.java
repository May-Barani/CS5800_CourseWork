package VendingMachine.VendingMachineStates;

import VendingMachine.Snack;
import VendingMachine.VendingMachine;

public class IdleState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName) {
        Snack snack = vendingMachine.getSnacks().get(snackName);
        if (snack != null && snack.getQuantity() > 0) {
            vendingMachine.setSelectedSnack(snack);
            vendingMachine.setState(new WaitingForMoneyState(vendingMachine));
            System.out.println("Selected snack: " + snackName);
        } else {
            System.out.println("Snack not available or out of stock.");
        }
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Select a snack first.");
    }

    @Override
    public void dispenseSnack() {
        System.out.println("Select a snack and insert money first.");
    }
}
