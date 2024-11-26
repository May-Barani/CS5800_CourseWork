package VendingMachine.Dispensers;

import VendingMachine.Snack;
import VendingMachine.VendingMachine;

public class KitKatDispenser extends SnackDispenseHandler {
    @Override
    public void handleRequest(VendingMachine machine, Snack selectedSnack, double insertedMoney) {
        if (selectedSnack.getName().equalsIgnoreCase("Kitkat")) {
            if (selectedSnack.getQuantity() > 0 && insertedMoney >= selectedSnack.getPrice()) {
                selectedSnack.dispense();
                System.out.println("Dispensed: Kitkat");
                machine.returnChange(insertedMoney - selectedSnack.getPrice());
            } else if (selectedSnack.getQuantity() == 0) {
                System.out.println("Cannot dispense Kitkat. It is out of stock.");
            } else {
                double remaining = selectedSnack.getPrice() - insertedMoney;
                System.out.printf("Cannot dispense Kitkat. Please insert at least $%.2f more.%n", remaining);
            }
        } else if (nextHandler != null) {
            nextHandler.handleRequest(machine, selectedSnack, insertedMoney);
        }
    }
}

