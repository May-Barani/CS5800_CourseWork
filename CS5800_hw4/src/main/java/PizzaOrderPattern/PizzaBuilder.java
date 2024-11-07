package PizzaOrderPattern;

public interface PizzaBuilder {

    PizzaBuilder setPizzaChainName(String pizzaChainName);
    PizzaBuilder setPizzaSize(String pizzaSize);
    PizzaBuilder setPizzaToppingsList(String... pizzaToppingsList);
    Pizza build();

}
