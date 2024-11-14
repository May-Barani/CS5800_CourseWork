package PizzaOrderPattern;
public class Main {
    public static void main(String[] args) {
        // Instantiate builders for each pizza chain
        PizzaHutPizzaBuilder smallPizzaHutBuilder = new PizzaHutPizzaBuilder();
        PizzaHutPizzaBuilder mediumPizzaHutBuilder = new PizzaHutPizzaBuilder();
        PizzaHutPizzaBuilder largePizzaHutBuilder = new PizzaHutPizzaBuilder();

        // Additional Pizza Hut pizzas
        PizzaHutPizzaBuilder pizzaHutLargePizzaBuilder = new PizzaHutPizzaBuilder();
        PizzaHutPizzaBuilder pizzaHutSmallPizzaBuilder = new PizzaHutPizzaBuilder();

        // Little Caesars
        LittleCaesarsPizzaBuilder littleCaesarsMediumPizzaBuilder = new LittleCaesarsPizzaBuilder();
        LittleCaesarsPizzaBuilder littleCaesarsSmallPizzaBuilder = new LittleCaesarsPizzaBuilder();

        // Dominos
        DominosPizzaBuilder dominosSmallPizzaBuilder = new DominosPizzaBuilder();
        DominosPizzaBuilder dominosLargePizzaBuilder = new DominosPizzaBuilder();

        // Manager to handle pizza building
        PizzaBuilderManager manager = new PizzaBuilderManager();

        // Construct pizzas as per requirements
        Pizza smallPizza = manager.constructSmallPizzaOfPizzaHut(smallPizzaHutBuilder);
        Pizza mediumPizza = manager.constructMediumPizzaOfPizzaHut(mediumPizzaHutBuilder);
        Pizza largePizza = manager.constructLargePizzaOfPizzaHut(largePizzaHutBuilder);

        Pizza ph1 = manager.constructPizzaHutLargePizza(pizzaHutLargePizzaBuilder);
        Pizza ph2 = manager.constructPizzaHutSmallPizza(pizzaHutSmallPizzaBuilder);

        Pizza lc1 = manager.constructLittleCaesarsMediumPizza(littleCaesarsMediumPizzaBuilder);
        Pizza lc2 = manager.constructLittleCaesarsSmallPizza(littleCaesarsSmallPizzaBuilder);

        Pizza d1 = manager.constructDominosSmallPizza(dominosSmallPizzaBuilder);
        Pizza d2 = manager.constructDominosLargePizza(dominosLargePizzaBuilder);

        // Call eat() to print details
        smallPizza.eat();
        mediumPizza.eat();
        largePizza.eat();
        ph1.eat();
        ph2.eat();
        lc1.eat();
        lc2.eat();
        d1.eat();
        d2.eat();
    }
}
