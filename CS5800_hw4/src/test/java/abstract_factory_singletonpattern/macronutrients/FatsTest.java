package abstract_factory_singletonpattern.macronutrients;

import abstract_factory_singletonpattern.DietPlan;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FatsTest {

    @Test
    void testGetComponentForPaleoDiet() {
        Fats fats = new Fats();
        String component = fats.getComponent(DietPlan.Paleo);
        assertTrue(component.equals("Avocado") || component.equals("Tuna") || component.equals("Peanuts"),
                "Paleo diet should not contain Sour cream.");
    }

    @Test
    void testGetComponentForVeganDiet() {
        Fats fats = new Fats();
        String component = fats.getComponent(DietPlan.Vegan);
        assertTrue(component.equals("Avocado") || component.equals("Peanuts"),
                "Vegan diet should not contain Tuna or Sour cream.");
    }

    @Test
    void testGetComponentForNutAllergyDiet() {
        Fats fats = new Fats();
        String component = fats.getComponent(DietPlan.Nut_Allergy);
        assertTrue(component.equals("Avocado") || component.equals("Sour cream") || component.equals("Tuna"),
                "Nut Allergy diet should not contain Peanuts.");
    }
}
