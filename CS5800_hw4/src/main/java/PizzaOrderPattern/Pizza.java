package PizzaOrderPattern;

import java.util.List;
public class Pizza {
    private String pizzaChainName;
    private String pizzaSize;
    private List<String> pizzaToppingsList;

    public Pizza(String pizzaChainName, String pizzaSize, List<String> pizzaToppingsList) {
        this.pizzaChainName = pizzaChainName;
        this.pizzaSize = pizzaSize;
        this.pizzaToppingsList = pizzaToppingsList;
    }

    public String getPizzaChainName() {
        return pizzaChainName;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public List<String> getPizzaToppingsList() {
        return pizzaToppingsList;
    }

    public void eat() {
        System.out.println(pizzaChainName + " - Your " + pizzaSize + " pizza with " + pizzaToppingsList.size() + " toppings includes the following:");
        for (String topping : pizzaToppingsList) {
            System.out.println("- " + topping);
        }
    }

}
