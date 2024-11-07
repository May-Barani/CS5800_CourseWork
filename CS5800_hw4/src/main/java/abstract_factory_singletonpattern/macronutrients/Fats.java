package abstract_factory_singletonpattern.macronutrients;
import abstract_factory_singletonpattern.DietPlan;

import java.util.Random;

public class Fats implements Macronutrient{

    private final String[] all_fatsOptions = {"Avocado", "Sour cream", "Tuna", "Peanuts"};
    private final String[] paleo_fatsOptions = {"Avocado", "Tuna", "Peanuts"};
    private final String[] vegan_fatsOptions = {"Avocado", "Peanuts"};
    private final String[] nuts_allergy_fatsOptions = {"Avocado", "Sour cream", "Tuna"};

    private final String[] Options = {""};

    @Override
    public String getComponent(DietPlan dietType) {
        Random rand = new Random();
        switch (dietType)
        {
            case Paleo -> {
                return paleo_fatsOptions[rand.nextInt(paleo_fatsOptions.length)];
            }
            case Vegan -> {
                return vegan_fatsOptions[rand.nextInt(vegan_fatsOptions.length)];
            }
            case Nut_Allergy -> {
                return nuts_allergy_fatsOptions[rand.nextInt(vegan_fatsOptions.length)];
            }
            default -> {
                return all_fatsOptions[rand.nextInt(all_fatsOptions.length)];
            }
        }



    }
}
