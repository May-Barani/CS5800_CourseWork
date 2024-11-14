package abstract_factory_singletonpattern.macronutrients;

import abstract_factory_singletonpattern.DietPlan;

import java.util.Random;

public class Protein implements Macronutrient{
    private final String[] proteinOptions = {"Fish", "Chicken", "Beef", "Tofu"};
    private final String[] paleo_proteinOptions = {"Fish", "Chicken", "Beef"};

    @Override
    public String getComponent(DietPlan dietType) {
        Random rand = new Random();

        switch (dietType)
        {
            case Paleo -> {
                return paleo_proteinOptions[rand.nextInt(paleo_proteinOptions.length)];
            }

            default -> {
                return proteinOptions[rand.nextInt(proteinOptions.length)];
            }
        }

    }
}
