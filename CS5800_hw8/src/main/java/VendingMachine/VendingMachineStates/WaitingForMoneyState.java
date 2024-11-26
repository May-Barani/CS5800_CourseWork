package VendingMachine.VendingMachineStates;

import VendingMachine.VendingMachine;

public class WaitingForMoneyState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public WaitingForMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName) {
        System.out.println("Snack already selected, please insert money.");
    }

    @Override
    public void insertMoney(double amount) {
        double total = vendingMachine.getInsertedMoney() + amount;
        vendingMachine.setInsertedMoney(total);
        System.out.printf("Inserted money: $%.2f%n", total);
        if (total >= vendingMachine.getSelectedSnack().getPrice()) {
            vendingMachine.setState(new DispensingSnackState(vendingMachine));
        } else {
            double remaining = vendingMachine.getSelectedSnack().getPrice() - total;
            System.out.printf("Please insert at least $%.2f more.%n", remaining);
        }
    }

    @Override
    public void dispenseSnack() {
        System.out.println("Please insert enough money.");
    }
}
