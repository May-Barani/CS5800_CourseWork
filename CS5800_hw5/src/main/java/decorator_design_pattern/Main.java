package decorator_design_pattern;

import decorator_design_pattern.basefood_items.Burger;
import decorator_design_pattern.basefood_items.FoodItems;
import decorator_design_pattern.basefood_items.Fries;
import decorator_design_pattern.basefood_items.HotDog;
import decorator_design_pattern.toppings_decorator.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Customer 1: 5 stars and order Burger with all toppings
        List<FoodItems> foodItemsList1 = new ArrayList<>();
        foodItemsList1.add(new BaconBits(new Lettuce(new Pickles(new ExtraCheese(new Ketchup(new Burger()))))));
        Order order1 = new Order();
        order1.setCustomerFoodItems(foodItemsList1);
        Customer customer1 = new Customer("Kris", 5, order1);

        // Customer 2: 4 stars and order HotDog with Ketchup, ExtraCheese, and Pickles
        List<FoodItems> foodItemsList2 = new ArrayList<>();
        foodItemsList2.add(new Pickles(new ExtraCheese(new Ketchup(new HotDog()))));
        Order order2 = new Order();
        order2.setCustomerFoodItems(foodItemsList2);
        Customer customer2 = new Customer("Scarlett", 4, order2);

        // Customer 3: 3 stars and order Fries with Ketchup and ExtraCheese
        List<FoodItems> foodItemsList3 = new ArrayList<>();
        foodItemsList3.add(new ExtraCheese(new Ketchup(new Fries())));
        Order order3 = new Order();
        order3.setCustomerFoodItems(foodItemsList3);
        Customer customer3 = new Customer("Anne", 3, order3);

        // Customer 4: 2 stars and also order Burger with all toppings
        List<FoodItems> foodItemsList4 = new ArrayList<>();
        foodItemsList4.add(new BaconBits(new Lettuce(new Pickles(new ExtraCheese(new Ketchup(new Burger()))))));
        Order order4 = new Order();
        order4.setCustomerFoodItems(foodItemsList4);
        Customer customer4 = new Customer("Taylor", 2, order4);

        // Customer 5: 1 star and order HotDog and Fries with Ketchup and ExtraCheese
        List<FoodItems> foodItemsList5 = new ArrayList<>();
        foodItemsList5.add(new Pickles(new ExtraCheese(new Ketchup(new HotDog()))));
        foodItemsList5.add(new ExtraCheese(new Ketchup(new Fries())));
        Order order5 = new Order();
        order5.setCustomerFoodItems(foodItemsList5);
        Customer customer5 = new Customer("Sabrina", 1, order5);

        displayTotalOrderCostWithDiscount(customer1);
        displayTotalOrderCostWithDiscount(customer2);
        displayTotalOrderCostWithDiscount(customer3);
        displayTotalOrderCostWithDiscount(customer4);
        displayTotalOrderCostWithDiscount(customer5);
    }

    public static void displayTotalOrderCostWithDiscount(Customer customer) {
        System.out.println("Customer Name      : " + customer.getCustomerName());
        System.out.println("Loyalty Status     : " + customer.getCustomerLoyaltyStatus() + " STAR");

        // Calculate total cost before discount
        double totalCostBeforeDiscount = 0;
        for (FoodItems item : customer.getOrder().getCustomerFoodItems()) {
            totalCostBeforeDiscount += item.cost();
        }

        double discountRate = customer.getOrder().getDiscount(customer.getCustomerLoyaltyStatus()) * 100;
        double totalCostAfterDiscount = customer.getOrder()
                .calculateOrderCostWithDiscountBasedOnCustomerLoyaltyStatus(customer.getCustomerLoyaltyStatus());
        double discountAmount = totalCostBeforeDiscount - totalCostAfterDiscount;

        List<FoodItems> foodItems = customer.getOrder().getCustomerFoodItems();
        System.out.println("Items Ordered      :");

        int i = 1;
        for (FoodItems foodItem : foodItems) {
            System.out.println("  " + i + ". " + foodItem.foodItemName());
            i++;
        }

        // Display cost breakdown
        System.out.printf("Total Cost Before Discount            : $%.2f%n", totalCostBeforeDiscount);
        System.out.printf("Discount Applied (%d STAR -> %.2f%%)   : -$%.2f%n",
                customer.getCustomerLoyaltyStatus(), discountRate, discountAmount);
        System.out.printf("Total Cost After Discount             : $%.2f%n", totalCostAfterDiscount);
        System.out.println("==================================================\n");
    }
}
