package VendingMachine.VendingMachineStates;

import VendingMachine.Snack;
import VendingMachine.VendingMachine;

public class DispensingSnackState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public DispensingSnackState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName) {
        System.out.println("Currently dispensing another snack. Please wait.");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Already have enough money. Dispensing snack.");
    }

    @Override
    public void dispenseSnack() {
        Snack snack = vendingMachine.getSelectedSnack();
        if (snack == null) {
            System.out.println("Invalid snack selected.");
            return;
        }
        if (vendingMachine.getInsertedMoney() >= snack.getPrice()) {
            snack.dispense();
            System.out.println("Dispensed: " + snack.getName());
            vendingMachine.returnChange(vendingMachine.getInsertedMoney() - snack.getPrice());
            vendingMachine.setState(new IdleState(vendingMachine));
        } else {
            System.out.printf("Not enough money. Please insert at least $%.2f more.%n",
                    snack.getPrice() - vendingMachine.getInsertedMoney());
            vendingMachine.setState(new WaitingForMoneyState(vendingMachine));
        }
    }
}



