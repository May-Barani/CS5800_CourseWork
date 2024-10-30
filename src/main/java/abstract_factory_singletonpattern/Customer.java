package abstract_factory_singletonpattern;

import java.util.ArrayList;
import java.util.List;
public class Customer {

    private final String customerName;
    private final DietPlan dietPlan;
    private final MacronutrientFactory_Singleton macronutrientFactory;

    public Customer(String name, DietPlan dietPlan) {
        this.customerName = name;
        this.dietPlan = dietPlan;
        this.macronutrientFactory = MacronutrientFactory_Singleton.getInstance();
    }

    public String getName() {
        return customerName;
    }

    public DietPlan getDietPlan() {
        return dietPlan;
    }

    // Method to generate a meal based on diet plan
    public Meal generateMealBasedOnDietPlan() {
        String carbs = null;
        String protein = null;
        String fats = null;

        switch (dietPlan) {
            case No_Restriction:
                carbs = macronutrientFactory.getCarbsFactory().createMacronutrient().getComponent(DietPlan.No_Restriction);
                protein = macronutrientFactory.getProteinFactory().createMacronutrient().getComponent(DietPlan.No_Restriction);
                fats = macronutrientFactory.getFatsFactory().createMacronutrient().getComponent(DietPlan.No_Restriction);
                break;

            case Paleo:
                carbs = "Pistachio";  // Restriction allows only pistachio for Paleo carbs
                protein = macronutrientFactory.getProteinFactory().createMacronutrient().getComponent(DietPlan.Paleo);
                fats = macronutrientFactory.getFatsFactory().createMacronutrient().getComponent(DietPlan.Paleo);
                break;

            case Vegan:
                carbs = macronutrientFactory.getCarbsFactory().createMacronutrient().getComponent(DietPlan.Vegan);
                protein = "Tofu";  // Tofu is a valid vegan protein substitute
                fats = macronutrientFactory.getFatsFactory().createMacronutrient().getComponent(DietPlan.Vegan);
                break;

            case Nut_Allergy:
                carbs = macronutrientFactory.getCarbsFactory().createMacronutrient().getComponent(DietPlan.Nut_Allergy);
                protein = macronutrientFactory.getProteinFactory().createMacronutrient().getComponent(DietPlan.Nut_Allergy);
                fats = macronutrientFactory.getFatsFactory().createMacronutrient().getComponent(DietPlan.Nut_Allergy);
                break;
        }

        return new Meal(carbs, protein, fats);
    }


}
