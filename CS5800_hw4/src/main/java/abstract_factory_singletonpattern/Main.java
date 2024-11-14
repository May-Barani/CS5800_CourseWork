package abstract_factory_singletonpattern;

public class Main {
    public static void main(String[] args) {
        //Create customers
        Customer customer1 = new Customer("Alex", DietPlan.No_Restriction);
        Customer customer2 = new Customer("Bella", DietPlan.Paleo);
        Customer customer3 = new Customer("John", DietPlan.Vegan);
        Customer customer4 = new Customer("David", DietPlan.Nut_Allergy);
        Customer customer5 = new Customer("Elle", DietPlan.Vegan);
        Customer customer6 = new Customer("Niel", DietPlan.Paleo);

        //Generate meals for customers
        generateMealForCustomer(customer1);
        generateMealForCustomer(customer2);
        generateMealForCustomer(customer3);
        generateMealForCustomer(customer4);
        generateMealForCustomer(customer5);
        generateMealForCustomer(customer6);
    }

    //Method for generating and printing meal for a customer
    /*
    private static void generateMealForCustomer(Customer customer) {
        Meal meal = customer.generateMealBasedOnDietPlan();
        System.out.println("Meal for " + customer.getName() + " (Diet Plan: " + customer.getDietPlan() + ")");
        for (String component : meal.getComponents()) {
            System.out.println(component);
        }
        System.out.println();
    }*/

    private static void generateMealForCustomer(Customer customer) {
        Meal meal = customer.generateMealBasedOnDietPlan();
        System.out.println("Meal for " + customer.getName() + " (Diet Plan: " + customer.getDietPlan() + ")");

        System.out.println("Carbs: " + meal.getCarbs());
        System.out.println("Protein: " + meal.getProtein());
        System.out.println("Fats: " + meal.getFats());

        System.out.println(); //
    }


}
