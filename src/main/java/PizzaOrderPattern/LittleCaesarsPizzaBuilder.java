package PizzaOrderPattern;

import java.util.Arrays;
import java.util.List;

public class LittleCaesarsPizzaBuilder implements PizzaBuilder{

    private String pizzaChainName;
    private String pizzaSize;
    private List<String> pizzaToppingsList;

    @Override
    public PizzaBuilder setPizzaChainName(String pizzaChainName) {
        this.pizzaChainName = pizzaChainName;
        return this;
    }

    @Override
    public PizzaBuilder setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
        return this;
    }

    @Override
    public PizzaBuilder setPizzaToppingsList(String... pizzaToppingsList) {
        this.pizzaToppingsList = Arrays.asList(pizzaToppingsList);
        return this;
    }

    @Override
    public Pizza build() {
        return new Pizza(pizzaChainName,pizzaSize,pizzaToppingsList);
    }
}
