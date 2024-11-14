package abstract_factory_singletonpattern.macronutrients;
import abstract_factory_singletonpattern.DietPlan;

import java.util.Random;

public class Carbs implements Macronutrient {

    private final String[] all_carbsOptions = {"Cheese","Bread", "Lentils", "Pistachio"};
    private final String[] vegan_carbsOptions = {"Bread", "Lentils", "Pistachio"};
    private final String[] nuts_allergy_carbsOptions = {"Cheese","Bread", "Lentils"};

    @Override
    public String getComponent(DietPlan dietType) {
        Random rand = new Random();
        switch (dietType)
        {
            case Vegan -> {
                return vegan_carbsOptions[rand.nextInt(vegan_carbsOptions.length)];
            }
            case Nut_Allergy -> {
                return nuts_allergy_carbsOptions[rand.nextInt(nuts_allergy_carbsOptions.length)];
            }
            default -> {
                return all_carbsOptions[rand.nextInt(all_carbsOptions.length)];
            }
        }
    }
}
