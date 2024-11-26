package VendingMachine;

public class VendingMachineDriver {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        System.out.println("Welcome to the CS Vending Machine!");
        System.out.println("Available snacks: Coke, Pepsi, Cheetos, Doritos, KitKat, Snickers");

        vendingMachine.selectAndInsertMoney("Coke", 3.0);
        vendingMachine.selectAndInsertMoney("Pepsi", 2.0);
        vendingMachine.selectAndInsertMoney("Cheetos", 5.0);
        vendingMachine.selectAndInsertMoney("Doritos", 5.0);
        vendingMachine.selectAndInsertMoney("KitKat", 0.5);
        vendingMachine.selectAndInsertMoney("Snickers", 1.0);

        System.out.println("\nThank you for using the Vending Machine! Have a great day!");


    }
}