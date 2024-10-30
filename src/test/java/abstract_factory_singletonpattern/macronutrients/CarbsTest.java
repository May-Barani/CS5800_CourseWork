package abstract_factory_singletonpattern.macronutrients;

import abstract_factory_singletonpattern.DietPlan;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarbsTest {

    @Test
    void testGetComponentForVeganDiet() {
        Carbs carbs = new Carbs();
        String component = carbs.getComponent(DietPlan.Vegan);
        assertTrue(component.equals("Bread") || component.equals("Lentils") || component.equals("Pistachio"),
                "Vegan diet should not contain Cheese.");
    }

    @Test
    void testGetComponentForNutAllergyDiet() {
        Carbs carbs = new Carbs();
        String component = carbs.getComponent(DietPlan.Nut_Allergy);
        assertTrue(component.equals("Cheese") || component.equals("Bread") || component.equals("Lentils"),
                "Nut Allergy diet should not contain Pistachio.");
    }
}
