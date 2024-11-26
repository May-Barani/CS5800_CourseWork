package VendingMachine.Dispensers;
import VendingMachine.Snack;
import VendingMachine.VendingMachine;

public class SnickersDispenser extends SnackDispenseHandler {
    @Override
    public void handleRequest(VendingMachine machine, Snack selectedSnack, double insertedMoney) {
        if (selectedSnack.getName().equalsIgnoreCase("Snickers")) {
            if (selectedSnack.getQuantity() > 0 && insertedMoney >= selectedSnack.getPrice()) {
                selectedSnack.dispense();
                System.out.println("Dispensed: Snickers");
                machine.returnChange(insertedMoney - selectedSnack.getPrice());
            } else if (selectedSnack.getQuantity() == 0) {
                System.out.println("Cannot dispense Snickers. It is out of stock.");
                machine.returnChange(insertedMoney);
            } else {
                double remaining = selectedSnack.getPrice() - insertedMoney;
                System.out.printf("Cannot dispense Snickers. Please insert at least $%.2f more.%n", remaining);
            }
        } else if (nextHandler != null) {
            nextHandler.handleRequest(machine, selectedSnack, insertedMoney);
        }
    }
}



