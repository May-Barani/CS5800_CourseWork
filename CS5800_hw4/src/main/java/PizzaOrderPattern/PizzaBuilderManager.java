package PizzaOrderPattern;

public class PizzaBuilderManager {
    public Pizza constructSmallPizzaOfPizzaHut(PizzaBuilder builder) {
        return builder.setPizzaChainName("Pizza Hut")
                .setPizzaSize("small")
                .setPizzaToppingsList("Ham and Pineapple","Bacon","Extra Cheese")
                .build();
    }

    public Pizza constructMediumPizzaOfPizzaHut(PizzaBuilder builder) {
        return builder.setPizzaChainName("Pizza Hut")
                .setPizzaSize("medium")
                .setPizzaToppingsList("Tomato and Basil","Spinach","Pepperoni","Mushroom","Ham","Extra Cheese")
                .build();
    }

    public Pizza constructLargePizzaOfPizzaHut(PizzaBuilder builder) {
        return builder.setPizzaChainName("Pizza Hut")
                .setPizzaSize("large")
                .setPizzaToppingsList("Beef", "Extra Cheese", "Spicy Pork", "Pepperoni", "Sausage", "Onions","Peppers", "Pesto", "Ham")
                .build();
    }

    public Pizza constructPizzaHutLargePizza(PizzaBuilder builder) {
        return builder.setPizzaChainName("Pizza Hut")
                .setPizzaSize("large")
                .setPizzaToppingsList("Extra Cheese","Ham and Pineapple","Peppers")
                .build();
    }

    public Pizza constructPizzaHutSmallPizza(PizzaBuilder builder) {
        return builder.setPizzaChainName("Pizza Hut")
                .setPizzaSize("small")
                .setPizzaToppingsList("Tomato and Basil","Pepperoni")
                .build();
    }

    public Pizza constructLittleCaesarsMediumPizza(PizzaBuilder builder) {
        return builder.setPizzaChainName("Little Caesars")
                .setPizzaSize("medium")
                .setPizzaToppingsList("Extra Cheese","Mushrooms","Onions","Pepperoni","Sausage","Spinach","Spicy Pork","Olives")
                .build();
    }
    public Pizza constructLittleCaesarsSmallPizza(PizzaBuilder builder) {
        return builder.setPizzaChainName("Little Caesars")
                .setPizzaSize("small")
                .setPizzaToppingsList("Tomato and Basil","Pepperoni","Sausage","Extra Cheese","Mushrooms","Bacon")
                .build();
    }

    public Pizza constructDominosSmallPizza(PizzaBuilder builder) {
        return builder.setPizzaChainName("Dominos")
                .setPizzaSize("small")
                .setPizzaToppingsList("Extra Cheese")
                .build();
    }
    public Pizza constructDominosLargePizza(PizzaBuilder builder) {
        return builder.setPizzaChainName("Dominos")
                .setPizzaSize("large")
                .setPizzaToppingsList("Spicy Pork","Spinach","Extra Cheese")
                .build();
    }

}